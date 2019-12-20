int factrial(int n)
{
	if (n <= 1) {
		return 1;
	}
	return n * factrial(n-1);
}

int main()
{
	printf("Enter an integer number: ");
	string val = input();
	int n = stoi(val);
	int ans = factrial(n);
	printf("Factrial of %d is %d\n", n, ans);
}
