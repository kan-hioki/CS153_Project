void func()
{
	return;
}
int main()
{
	int i = 10, j = 20, k = 30;
	if (i == 10) {
		printf("%d\n", j);
	} else {
	
		printf("%d\n", k);
	}

	i = 0;
	while (i < 10) {
		printf("%d\n", i);
		i++;
	}

	for (int l = 0; l < 10; l++) {
		printf("%d\n", l);
	}

	func();
	return 0;
}

