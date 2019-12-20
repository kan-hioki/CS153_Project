int L[9999], R[9999];

void merge(int A[], int n, int left, int mid, int right)
{
	int n1 = mid - left;
	int n2 = right - mid;

	for (int i = 0; i < n1; i++) {
		L[i] = A[left + i];


	}
	for (i = 0; i < n2; i++) {
		R[i] = A[mid + i];


	}
	L[n1] = 999999;
	R[n2] = 999999;

	i = 0;
	int j = 0;
	for (int k = left; k < right; k++) {
		if (L[i] <= R[j]) {
			A[k] = L[i];
			i++;
		} else {
			A[k] = R[j];
			j++;
		}
	}
	return;
}

void mergeSort(int A[], int n, int left, int right)
{
	if (left+1 < right) {
		int mid = (left + right) / 2;

		mergeSort(A, n, left, mid);
		mergeSort(A, n, mid, right);
		merge(A, n, left, mid, right);
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

	mergeSort(A, n, 0, n);
	
	printf("\nSorted numbers:\n");
	i = 0;
	while (i < n) {
		printf("%d ", A[i]);
		i++;
	}
	printf("\n");
	return;
}
