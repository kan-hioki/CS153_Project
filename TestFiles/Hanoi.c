void hanoi(int n, int pole1, int pole2, int pole3)
{
	if (n == 1) {
		printf("Move disk %d from pole %d to pole %d\n", n, pole1, pole2);
	} else {
		hanoi(n-1, pole1, pole3, pole2);
		printf("Move disk %d from pole %d to pole %d\n", n, pole1, pole2);
		hanoi(n-1, pole3, pole2, pole1);
	}
	return;
}

int main()
{
	printf("Enter the number of disks: ");
	string n = input();
	int nDisk = stoi(n);
	hanoi(nDisk, 1, 2, 3); 
	return;
}
