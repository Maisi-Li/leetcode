/* 
 * utils.c	- utility functions
 *
 * sish		- a simple shell
 *
 * Members:
 *		- Gong Cheng,	gcheng2@stevens.edu
 *		- Maisi Li,	mli27@stevens.edu
 *
 * Usage:	- ./sish [-x][-c command]
 */
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "sish.h"
#include "utils.h"

/* check syntax for the input */
int
syntax_check(char *line, int *is_bg)
{
	if (strcmp(line,"")==0) return 0;
	if (line[strlen(line) - 1] == '&') {
		*is_bg = 1;
		line[strlen(line) - 1] = '\0';
	}
	else
		*is_bg = 0;
	return 1;
}

/* split commands by '|', return the number of commands */
int
command_parser(char *line, char cmd[MAX_CMD][MAX_CMD_LEN])
{
	int count;
	int i, j;
	int len;
	int is_ws;

	is_ws = 0;
	len = strlen(line);
	count = 0;
	i = 0;

	while (i < len) {
		while (i < len && whitespace(line[i]))
			i++;
		if (i == len)
			break;
		j = 0;
		while (i < len) {
			if (line[i] == '|') {
				i++;
				break;
			} else if (whitespace(line[i])) {
				if (!is_ws) {
					cmd[count][j] = ' ';
					j++;
				}
				i++;
				is_ws = 1;
			} else if (line[i] == '>'){
				if (!is_ws) {
					cmd[count][j] = ' ';
					j++;
				}
				cmd[count][j] = '>';
				j++;
				i++;
				if (i < len && line[i] == '>') {
					cmd[count][j] = '>';
					j++;
					i++;
				}
				cmd[count][j] = ' ';
				j++;
				is_ws = 1;
			} else if (line[i] == '<') {
				if (!is_ws) {
					cmd[count][j] = ' ';
					j++;
				}
				cmd[count][j] = '<';
				j++;
				cmd[count][j] = ' ';
				j++;
				i++;
				is_ws = 1;
			} else {
				cmd[count][j] = line[i];
				j++;
				i++;
				is_ws = 0;
			}
		}
		cmd[count][j] = '\0';
		count++;
	}
	
	return count;
}

/* initial COMMAND struct */
void
command_init(COMMAND *command)
{
	strcpy(command->input, "");
	strcpy(command->output, "");
	command->append = 0;
	command->arg[0] = NULL;
}

/* parse command string to COMMAND struct */
void
argument_parser(char *cmd, char buf[MAX_ARGC][MAX_ARG_LEN], COMMAND *command)
{
	int input_flag, output_flag, append_flag;
	int count;
	char *token = " \t";
	char tmp[MAX_CMD_LEN];
	char *str;

	strcpy(tmp, cmd);

	input_flag = output_flag = append_flag = 0;
	count = 0;
	str = strtok(tmp, token);

	while (str != NULL) {
		if (strcmp(str, ">") == 0) {
			output_flag = 1;
			append_flag = 0;
		} else if (strcmp(str, "<") == 0) {
			input_flag = 1;
		} else if (strcmp(str, ">>") == 0) {
			output_flag = 1;
			append_flag = 1;
		} else {
			if (input_flag) {
				input_flag = 0;
				strcpy(command->input, str);
			} else if (output_flag) {
				output_flag = 0;
				if (append_flag)
					command->append = 1;
				else
					command->append = 0;

				strcpy(command->output, str);
			} else {
				strcpy(buf[count], str);
				command->arg[count] = buf[count];
				count++;
			}
		}
		str = strtok(NULL, token);
	}
	command->arg[count] = NULL;
}

/* check space or tab */
static int
whitespace(char c)
{
	if (c == ' ' || c == '\t')
		return 1;
	else
		return 0;
}
