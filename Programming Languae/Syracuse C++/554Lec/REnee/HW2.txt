//HW2
//Due: Wednesday (9/26) at 11:59pm

#include <iostream>
#include <list>
#include <vector>
#include <string>

using namespace std;

//Write code for the following five functions
//In both DB1_print and DB2_print, you are required to use index function (i.e., []) for vector, rather than iterator

void DB1_print(vector<list<list<string>>> &DB1);
void DB1_to_DB2(vector<list<list<string>>> &DB1, list<vector<list<string> * > *> &DB2);
void DB2_print(list<vector<list<string> * > *> &DB2);
void DB2_to_DB3(list<vector<list<string> * > *> &DB2, list < list<list<string *> * > > &DB3);
void DB3_print(list < list<list<string *> * > > &DB3);

int main() {
	vector<list<list<string>>> DB1 = {
		{ { "cat", "dog" },{ "duck", "chicken","pig" } },
	{ { "lion", "tiger", "hyena", "leopard" },{ "Zebra", "elephant" },{ "buffalo" } } 
	};
	DB1_print(DB1);
	list<vector<list<string> * > *> DB2;
	DB1_to_DB2(DB1, DB2);
	DB2_print(DB2);
	list < list<list<string *> * > > DB3;
	DB2_to_DB3(DB2, DB3);
	DB3_print(DB3);
	getchar();
	getchar();
	return 0;
}
void DB1_print(vector<list<list<string>>> &DB1) {
	//Your code
}

void DB1_to_DB2(vector<list<list<string>>> &DB1, list<vector<list<string> * > *> &DB2) {
	//Your code
}

void DB2_print(list<vector<list<string> * > *> &DB2) {
	//Your code
}

void DB2_to_DB3(list<vector<list<string> * > *> &DB2, list < list<list<string *> * > > &DB3) {
	//Your code
}
void DB3_print(list < list<list<string *> * > > &DB3) {
	//Your code
}

//The following is a sample screenshot
//Your output needs to folloiwng idential format
/*

cat dog
duck chicken pig

lion tiger hyena leopard
Zebra elephant
buffalo


cat dog
duck chicken pig

lion tiger hyena leopard
Zebra elephant
buffalo


cat dog
duck chicken pig

lion tiger hyena leopard
Zebra elephant
buffalo
*/