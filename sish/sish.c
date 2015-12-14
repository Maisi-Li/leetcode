/* 
 * sish.c	- main program for sish
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
#include <sys/wait.h>

#include <limits.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

#include "sish.h"

int cflag;
int xflag;
char *ccmd;
int ret_val;
pid_t processid;

static void usage();

int
main(int argc, char **args)
{
	int opt;
	char *path;

	while ((opt = getopt(argc, args, "c:x")) != -1) {
		switch (opt) {
		case 'c':
			cflag = 1;
			ccmd = optarg;
			break;
		case 'x':
			xflag = 1;
			break;
		default:
			usage();
		}
	}

	path = NULL;

	if ((path = getcwd(path, PATH_MAX)) == NULL) {
		perror("getcwd() error");
		return EXIT_FAILURE;
	}

	if (setenv("SHELL", path, 1) == -1) {
		perror("setenv() error");
		return EXIT_FAILURE;
	}

	free(path);

	ret_val = EXIT_SUCCESS;
	processid = getpid();

	return execute();
}

static void
usage()
{
	fprintf(stderr, "Usage: ./sish [-x][-c command]\n");
	exit(EXIT_FAILURE);
}
