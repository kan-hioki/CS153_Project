int board[4][4];

int moveLeft()
{
	int regBoard[4][4];
	int i = 0, j = 0;
	while (i < 4) {
        j = 0;
		while (j < 4) {
			regBoard[i][j] = board[i][j];
			j = j + 1;
		}
		i = i + 1;
	}
	i = 0;
	while (i < 4) {
		if (board[i][0] == 0) {
			board[i][0] = board[i][1];
			board[i][1] = 0;
		}
		if (board[i][1] == 0) {
			board[i][1] = board[i][2];
			board[i][2] = 0;
			if (board[i][0] == 0) {
				board[i][0] = board[i][1];
				board[i][1] = 0;
			}
		}
		if (board[i][2] == 0) {
			board[i][2] = board[i][3];
			board[i][3] = 0;
			if (board[i][1] == 0) {
				board[i][1] = board[i][2];
				board[i][2] = 0;
				if (board[i][0] == 0) {
					board[i][0] = board[i][1];
					board[i][1] = 0;
				}
			}
		}

		if (board[i][0] == board[i][1]) {
			board[i][0] = board[i][0] + board[i][1];
			if (board[i][2] == board[i][3]) {
				board[i][1] = board[i][2] + board[i][3];
				board[i][2] = 0;
				board[i][3] = 0;
			}
			else {
				board[i][1] = board[i][2];
				board[i][2] = board[i][3];
				board[i][3] = 0;
			}
		} else {
			if (board[i][1] == board[i][2]) {
				board[i][1] = board[i][1] + board[i][2];
				board[i][2] = board[i][3];
				board[i][3] = 0;
			}
			else {
				if (board[i][2] == board[i][3]) {
					board[i][2] = board[i][2] + board[i][3];
					board[i][3] = 0;
				}
			}
		}

		i = i + 1;
	}

	i = 0;
	while (i < 4) {
        j = 0;
		while (j < 4) {
			if (regBoard[i][j] != board[i][j]) {
				return 1;
			}
			j = j + 1;
		}
		i = i + 1;
	}
	return 0;
}

int moveRight()
{
	int regBoard[4][4];
	int i = 0, j = 0;
	while (i < 4) {
        j = 0;
		while (j < 4) {
			regBoard[i][j] = board[i][j];
			j = j + 1;
		}
		i = i + 1;
	}
	i = 0;
	while (i < 4) {
		if (board[i][3] == 0) {
			board[i][3] = board[i][2];
			board[i][2] = 0;
		}
		if (board[i][2] == 0) {
			board[i][2] = board[i][1];
			board[i][1] = 0;
			if (board[i][3] == 0) {
				board[i][3] = board[i][2];
				board[i][2] = 0;
			}
		}
		if (board[i][1] == 0) {
			board[i][1] = board[i][0];
			board[i][0] = 0;
			if (board[i][2] == 0) {
				board[i][2] = board[i][1];
				board[i][1] = 0;
				if (board[i][3] == 0) {
					board[i][3] = board[i][2];
					board[i][2] = 0;
				}
			}
		}

		if (board[i][3] == board[i][2]) {
			board[i][3] = board[i][3] + board[i][2];
			if (board[i][1] == board[i][0]) {
				board[i][2] = board[i][1] + board[i][0];
				board[i][1] = 0;
				board[i][0] = 0;
			}
			else {
				board[i][2] = board[i][1];
				board[i][1] = board[i][0];
				board[i][0] = 0;
			}
		} else {
			if (board[i][2] == board[i][1]) {
				board[i][2] = board[i][2] + board[i][1];
				board[i][1] = board[i][0];
				board[i][0] = 0;
			}
			else {
				if (board[i][1] == board[i][0]) {
					board[i][1] = board[i][1] + board[i][0];
					board[i][0] = 0;
				}
			}
		}

		i = i + 1;
	}

	i = 0;
	while (i < 4) {
        j = 0;
		while (j < 4) {
			if (regBoard[i][j] != board[i][j]) {
				return 1;
			}
			j = j + 1;
		}
		i = i + 1;
	}
	return 0;
}

int moveUp()
{
	int regBoard[4][4];
	int i = 0, j = 0;
	while (i < 4) {
        j = 0;
		while (j < 4) {
			regBoard[i][j] = board[i][j];
			j = j + 1;
		}
		i = i + 1;
	}
	j = 0;
	while (j < 4) {
		if (board[0][j] == 0) {
			board[0][j] = board[1][j];
			board[1][j] = 0;
		}
		if (board[1][j] == 0) {
			board[1][j] = board[2][j];
			board[2][j] = 0;
			if (board[0][j] == 0) {
				board[0][j] = board[1][j];
				board[1][j] = 0;
			}
		}
		if (board[2][j] == 0) {
			board[2][j] = board[3][j];
			board[3][j] = 0;
			if (board[1][j] == 0) {
				board[1][j] = board[2][j];
				board[2][j] = 0;
				if (board[0][j] == 0) {
					board[0][j] = board[1][j];
					board[1][j] = 0;
				}
			}
		}

		if (board[0][j] == board[1][j]) {
			board[0][j] = board[0][j] + board[1][j];
			if (board[2][j] == board[3][j]) {
				board[1][j] = board[2][j] + board[3][j];
				board[2][j] = 0;
				board[3][j] = 0;
			}
			else {
				board[1][j] = board[2][j];
				board[2][j] = board[3][j];
				board[3][j] = 0;
			}
		} else {
			if (board[1][j] == board[2][j]) {
				board[1][j] = board[1][j] + board[2][j];
				board[2][j] = board[3][j];
				board[3][j] = 0;
			}
			else {
				if (board[2][j] == board[3][j]) {
					board[2][j] = board[2][j] + board[3][j];
					board[3][j] = 0;
				}
			}
		}

		j = j + 1;
	}

	i = 0;
	while (i < 4) {
        j = 0;
		while (j < 4) {
			if (regBoard[i][j] != board[i][j]) {
				return 1;
			}
			j = j + 1;
		}
		i = i + 1;
	}
	return 0;
}

int moveDown()
{
	int regBoard[4][4];
	int i = 0, j = 0;
	while (i < 4) {
        j = 0;
		while (j < 4) {
			regBoard[i][j] = board[i][j];
			j = j + 1;
		}
		i = i + 1;
	}
	j = 0;
	while (j < 4) {
		if (board[3][j] == 0) {
			board[3][j] = board[2][j];
			board[2][j] = 0;
		}
		if (board[2][j] == 0) {
			board[2][j] = board[1][j];
			board[1][j] = 0;
			if (board[3][j] == 0) {
				board[3][j] = board[2][j];
				board[2][j] = 0;
			}
		}
		if (board[1][j] == 0) {
			board[1][j] = board[0][j];
			board[0][j] = 0;
			if (board[2][j] == 0) {
				board[2][j] = board[1][j];
				board[1][j] = 0;
				if (board[3][j] == 0) {
					board[3][j] = board[2][j];
					board[2][j] = 0;
				}
			}
		}

		if (board[3][j] == board[2][j]) {
			board[3][j] = board[3][j] + board[2][j];
			if (board[1][j] == board[0][j]) {
				board[2][j] = board[1][j] + board[0][j];
				board[1][j] = 0;
				board[0][j] = 0;
			}
			else {
				board[2][j] = board[1][j];
				board[1][j] = board[0][j];
				board[0][j] = 0;
			}
		} else {
			if (board[2][j] == board[1][j]) {
				board[2][j] = board[2][j] + board[1][j];
				board[1][j] = board[0][j];
				board[0][j] = 0;
			}
			else {
				if (board[1][j] == board[0][j]) {
					board[1][j] = board[1][j] + board[0][j];
					board[0][j] = 0;
				}
			}
		}

		j = j + 1;
	}

	i = 0;
	while (i < 4) {
        j = 0;
		while (j < 4) {
			if (regBoard[i][j] != board[i][j]) {
				return 1;
			}
			j = j + 1;
		}
		i = i + 1;
	}
	return 0;
}

int moveCheck()
{
	int regBoard[4][4];
	int i = 0, j = 0;
	while (i < 4) {
        j = 0;
		while (j < 4) {
			regBoard[i][j] = board[i][j];
			j = j + 1;
		}
		i = i + 1;
	}
	int canMove = 0;
	canMove = moveUp();
	if (canMove == 1) {
        i = 0;
        while (i < 4) {
            j = 0;
            while (j < 4) {
                board[i][j] = regBoard[i][j];
                j = j + 1;
            }
            i = i + 1;
        }
        return 1;
	}
	canMove = moveDown();
	if (canMove == 1) {
        i = 0;
        while (i < 4) {
            j = 0;
            while (j < 4) {
                board[i][j] = regBoard[i][j];
                j = j + 1;
            }
            i = i + 1;
        }
        return 1;
	}
	canMove = moveLeft();
	if (canMove == 1) {
        i = 0;
        while (i < 4) {
            j = 0;
            while (j < 4) {
                board[i][j] = regBoard[i][j];
                j = j + 1;
            }
            i = i + 1;
        }
        return 1;
	}
	canMove = moveRight();
	if (canMove == 1) {
        i = 0;
        while (i < 4) {
            j = 0;
            while (j < 4) {
                board[i][j] = regBoard[i][j];
                j = j + 1;
            }
            i = i + 1;
        }
        return 1;
	}
	return 0;
}

int state()
{
	int i = 0, j = 0;
	while (i < 4) {
		while (j < 4) {
			if (board[i][j] == 2048) {
                return 1;
			}
			j = j + 1;
		}
		i = i + 1;
	}
	if (moveCheck() == 0) {
		return 2;
	}
	return 0;
}

int main()
{
	int i = 0, j = 0;
	int r, ri, rj;
	while (i < 4) {
        j = 0;
		while (j < 4) {
			r = rand() % 5 + 4;
			if (r < 1) {
				board[i][j] = 4;
			} else {
				if (r < 3) {
					board[i][j] = 2;
				} else {
					board[i][j] = 0;
				}
			}
			j = j + 1;
		}
		i = i + 1;
	}
	board[0][0] = 2;
	int s = state();
	int isMove = 0;
	while (s == 0) {
		i = 0;
		while (i < 4) {
			printf("%4d %4d %4d %4d\n", board[i][0], board[i][1], board[i][2], board[i][3]);
			i = i + 1;
		}
		printf("\n");
		printf("Enter next move(1 for Up, 2 for Down, 3 for Left, 4 for Right, or 0 to quit): ");
		string moveDir = input();
		int move = stoi(moveDir);
		if (move == 0) {
			printf("End game.\n");
			s = 3;
		}
		else {
			if (move == 1) {
				isMove = moveUp();
			}
			if (move == 2) {
				isMove = moveDown();
			}
			if (move == 3) {
				isMove = moveLeft();
			}
			if (move == 4) {
				isMove = moveRight();
			}
			if (isMove == 0) {
				printf("Cannot move this direction. Try again.\n");
			}
			else {
	            int put = 0;
	            while (put == 0) {
	                ri = (rand() % 100 + 100) / 50;
	                rj = (rand() % 100 + 100) / 50;
	                if (board[ri][rj] == 0) {
	                    put = 1;
	                    r = rand() % 3 + 2;
	                    if (r < 1) {
	                        board[ri][rj] = 4;
	                    } else {
	                        board[ri][rj] = 2;
	                    }
	                }
	            }
			}
			s = state();
		}
	}
	if (s == 1) {
		printf("you win");
	}
	if (s == 2) {
		printf("you lose");
	}
}