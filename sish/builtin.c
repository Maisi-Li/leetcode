/* 
 * builtin.c	- functions for builtin commands
 *
 * sish		- a simple shell
 *
 * Members:
 *		- Gong Cheng,	gcheng2@stevens.edu
 *		- Maisi Li,	mli27@stevens.edu
 *
 * Usage:	- ./sish [-x][-c command]
 */
#include <sys/types.h>

#include <errno.h>
#include <limits.h>
#include <pwd.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

#include "sish.h"

/* return 0 on success, -1 on error */
int
exit_syntax_check(char *arg[MAX_ARGC])
{
	if (arg[1] != NULL)
		return -1;
	else
		return 0;
}

/* return 0 on success, -1 on error */
int
cd_syntax_check(char *arg[MAX_ARGC])
{
	if (arg[1] == NULL || arg[2] == NULL)
		return 0;
	else
		return -1;
}

/* return -1 on error, 0 on success */
int
cd_exec(char *arg[MAX_ARGC])
{
	uid_t uid;
	struct passwd *usr;
	char path[PATH_MAX];
	if (arg[1] == NULL) {	/* home directory */
		uid = getuid();
		if ((usr = getpwuid(uid)) != NULL) {
			snprintf(path, PATH_MAX, "/home/%s", usr->pw_name);
		} else {
			if (errno != 0)
				fprintf(stderr, "sish: cd: getpwuid() error: "
					"%s\n", strerror(errno));
			else
				fprintf(stderr, "sish: cd: getpwuid() error: "
					"username not found\n");
			return -1;
		}
	} else	/* dir */
		strncpy(path, arg[1], PATH_MAX);

	if (chdir(path) == -1) {
		fprintf(stderr, "sish: cd: %s: chdir() error: %s\n",
			path, strerror(errno));
		return -1;
	}

	return 0;

}

/* we assume echo always success */
void
echo_exec(char *arg[MAX_ARGC])
{
	char **tmp;
	
	for (tmp = arg + 1; *tmp != NULL; tmp++) {
		if (strcmp(*tmp, "$?") == 0)
			printf("%d ", ret_val);
		else if (strcmp(*tmp, "$$") == 0)
			printf("%d ", processid);
		else
			printf("%s ", *tmp);
	}
	printf("\n");
	fflush(stdout);
}

void
exit_usage()
{
	fprintf(stderr, "sish: exit: usage: exit\n");
}

void
cd_usage()
{
	fprintf(stderr, "sish: cd: usage: cd [dir]\n");
}
