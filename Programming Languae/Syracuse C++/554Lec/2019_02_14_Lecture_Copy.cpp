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
	big_data() { p_data = new vector<int>; cout<<"constructor"<<this<<endl;}
	big_data(int k) { p_data = new vector<int>(k);cout<<"constructo argument"<<this<<endl; }
	~big_data() { delete p_data;
	
	cout << "Leaving Destructor" <<this<< endl;
	} //destructor
	//destructor will be invoked when delete is used or when
	//a variable is going out of scope

	big_data(const big_data &B) : big_data(){
		*(p_data) = *(B.p_data);
		cout << "Leaving copy constructor" << endl;
	}



	big_data(const initializer_list<int> & V) : big_data() {
		//p_data = new vector<int>;
		//you can use this to replace the above big_data();
		*p_data = V;
		cout << "Leaving Initializer_list" << endl;
	}

	void operator=(const big_data &B){
		*p_data = *(B.p_data);
		cout << "Leaving L-value operator =" << endl;
		}



	big_data ThreeTimes() {
		big_data temp(p_data->size());
		for (size_t i = 0; i < p_data->size(); i++) {
			(*(temp.p_data))[i] = 3* (*p_data)[i];
		}
		cout << "Leaving Three_Times" << endl;
		return move(temp);//change temp into an R-vlaue
	}

	//move construtor

	big_data(big_data &&B): big_data(){
		p_data = B.p_data;
		B.p_data = nullptr;
		cout << "Leaving move constructor" << endl;
	}

	void operator=(big_data &&B){
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

int main() {
	cout<<1<<endl;
	big_data *p1 = new big_data;
	delete p1;//Without destructor, the default one is
	//shallow delete

	cout<<2<<endl;
	big_data  B1 = { 1,2,3,4,5 };//will invoke initializer_list
	cout << B1;

	cout<<3<<endl;
	big_data B2(B1);//will invoke copy constructor
	cout << B2;

	cout<<4<<endl;
	big_data B3;
	B3 = B1;//will invoke operator=
	//default is shallow copy
	cout << B3;

	cout<<5<<endl;
	(*(B1.p_data))[2] = 100;
	cout << B1 << B2 << B3;
    //B1 : 1 2 100 4 5
	
	cout<<6<<endl;
	big_data B4;
	B4 = B1.ThreeTimes();
	//compiler will change it into
	//B4.operator=(B1.ThreeTimes());
	cout << B4;



	getchar();
	getchar();
	return 0;
}
