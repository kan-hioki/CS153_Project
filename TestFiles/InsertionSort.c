void insertionSort(int A[])
{
	int j, i, v;
	i = 1;
	while (i < 5) {
		v = A[i];
		j = i - 1;
		while (j >= 0 && A[j] > v) {
			A[j + 1] = A[j];
			j--;
		}
		A[j + 1] = v;
		i++;
	}
	return;
}

int main()
{
	int A[4096];
	printf("Enter the number of elements [0-4096]: ");
	string s = input();
	int n = stoi(s);
	printf("Enter %d integer numbers to be sorted(Press enter each time)\n", n);
	int i = 0;
	while (i < n) {
		printf("> ");
		string num = input();
		A[i] = stoi(num);
		i++;
	}
	
	insertionSort(A);
	
	printf("\nSorted numbers:\n");
	i = 0;
	while (i < n) {
		printf("%d ", A[i]);
		i++;
	}
}
