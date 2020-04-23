//copy constructor, destructor, move constructor
//operator=, L-value, R-value

//L-value: Any object that occupies an identifiable memory location
//Any object that can appear on left side of an assignment statement
//examples of L-vlae: j, i, temp, A[4]
//R-value: any object that can only appear on right side
//examples of R-value: 40, i+1, etc.
#include <iostream>
#include <vector>

using namespace std;

class big_data {
public:
	vector<int> *p_data;
	big_data() { p_data = new vector<int>; }
	big_data(int k) { p_data = new vector<int>(k); }
	~big_data() {
		delete p_data;
		cout << "Leaving Destructor" << endl;
	} //destructor
	//destructor will be invoked when delete is used or when
	//a variable is going out of scope

	big_data(const big_data &B) : big_data() {
		*(p_data) = *(B.p_data);
		cout << "Leaving copy constructor" << endl;
	}



	big_data(const initializer_list<int> & V) : big_data() {
		//p_data = new vector<int>;
		//you can use this to replace the above big_data();
		*p_data = V;
		cout << "Leaving Initializer_list" << endl;
	}

	big_data & operator=(const big_data &B) {
		*p_data = *(B.p_data);
		cout << "Leaving L-value operator =" << endl;
		return *this;

	}



	big_data ThreeTimes() {
		big_data temp(p_data->size());
		for (size_t i = 0; i < p_data->size(); i++) {
			(*(temp.p_data))[i] = 3 * (*p_data)[i];
		}
		cout << "Leaving Three_Times" << endl;
		return move(temp);//change temp into an R-vlaue
	}

	//move construtor

	big_data(big_data &&B) : big_data() {
		p_data = B.p_data;
		B.p_data = nullptr;
		cout << "Leaving move constructor" << endl;
	}

	void operator=(big_data &&B) {
		p_data = B.p_data;
		B.p_data = nullptr;
		cout << "Leaving R-value operator = " << endl;
	}




};

ostream & operator<<(ostream &str, const big_data &B) {
	for (int i : *(B.p_data)) { str << i << " "; }
	str << endl;
	return str;
}

void F1(big_data t) {//call by value will invoke
	//copy constructor
	cout << t.p_data->size() << endl;
}
void F2(int &t) {}//L-value parameter
void F2(int  &&t) {}//R-value parameter



/*
F2(i+1);//R-value
F2(i); //L-value
F2(40);//error


*/




int main() {
	big_data *p1 = new big_data;
	delete p1;//Without destructor, the default one is
	//shallow delete
	big_data  B1 = { 1,2,3,4,5 };//will invoke initializer_list
	cout << B1;
	big_data B2(B1);//will invoke copy constructor
	//the above statement can be equivalently written
	//as big_data B2 = B1;
	cout << B2;
	big_data B3;
	B3 = B1;//will invoke operator=
	//default is shallow copy
	cout << B3;
	(*(B1.p_data))[2] = 100;
	cout << B1 << B2 << B3;
	big_data B4;
	B4 = B1.ThreeTimes();
	//compiler will change it into
	//B4.operator=(B1.ThreeTimes());
	cout << B4;
	cout << endl;
	F1(B1);

	big_data B5, B6, B7;
	B5 = B6 = B7 = B1;


	getchar();
	getchar();
	return 0;
}
