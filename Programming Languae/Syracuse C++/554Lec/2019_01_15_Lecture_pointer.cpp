#include <iostream>
using namespace std;


int main() {
	int i = 10, j = 20, k;
	char c = 'T';
	cout << i << "  " << c << j << endl; //"\n";
	cout << " input values" << endl;
	cin >> j >> c >> k;
	cout << j << " " << c << " " << k << endl;

	int *p1 = &i;//& address , reference

	//delete p1;  this will give you error.  only dynamically created objects can be deleted

	cout << *p1 << endl;// * is a function that returns the value/variable at the address
	*p1 = 3000;//the same as i = 3000;

	//dyanmaic memory allocation

	p1 = new int(45); //new will ask system to allocate memory space for int and returns the address
	//the int will be initialized to 45

	delete p1;//delete the object pointed by p1;
	//cout << *p1 << endl;  Error! the object pointed by p1 has been deleted
	p1 = &k;

	int A[5] = { 0,1,2,3,4 };
	cout << "*A = " << A << endl;//Array name without index is the address of the first array element
	//the same as cout << A[0] << endl;
	cout << *(A + 2) << endl; //the same as cout << A[2]
	cout << 3[A] << endl; //the same as A[3]
	//both 3[A] and A[3] will be converted by compiler into *(A+3)

	cout << A[20] << endl;

	int *p2 = new int[5];
	*(p2 + 2) = 30;
	delete[] p2;// Delete the entire array pointed by p2
	//without [], only the first element will be deleted

	int B[3][4];
	B[2][3] = 500;
	cout << B[2][3] << endl;
	cout << *(*(B + 2) + 3) << endl;
	cout << *(B[2] + 3) << endl;
	cout << *(&B[0][0] + 2 * 4 + 3) << endl;



	getchar();
	getchar();
	return 0;

}
