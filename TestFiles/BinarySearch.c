int binarySearch(int A[], int n, int key)
{
	int left = 0;
	int right = n;
	int mid;
	while (left < right) {
		mid = (left + right) / 2;
		if (key == A[mid]) {
			return mid;
		}
		if (key > A[mid]) {
			left = mid + 1;
		} else {
			if (key < A[mid]) {
				right = mid;
			}
		}
	}
	return 999999;
}

int main()
{
	int A[4096];
	printf("Enter the number of elements [0-4096]: ");
	string s1 = input();
	int n = stoi(s1);
	
	printf("Enter %d sorted integer numbers(Press enter each time)\n", n);
	int i = 0;
	while (i < n) {
		printf("> ");
		string num = input();
		A[i] = stoi(num);
		i = i + 1;
	}
	
	printf("Enter the search key: ");
	string s2 = input();
	int key = stoi(s2);
	
	int ans = binarySearch(A, n, key);
	
	if (ans != 999999) { 
		printf("\nThe key is found at %d\n", ans);
	} else {
		printf("\nThe key is not found\n");
	}
	return;
}
