//namespace
#include <iostream>
//#include "Header1.h"

int x = 30;
namespace one {
	int x = 10;
	//you can also define functions, classes, etc.

	namespace in_one {
		int y = 100;
	}
}
namespace two {

	int x = 20;
}

int main() {
	using namespace std;
	int x = 50;
	{
		using namespace one;
		std::cout << x << std::endl; // Error!
		std::cout <<::x<<" "<< one::x<<" "<< two::x << std::endl;
		//::x global x
	
	}
	{
		//local variable > global variable = namespace variable
		using namespace two;
		std::cout << x << std::endl;


	}
	{
		using namespace one::in_one;
		std::cout << y << std::endl;//multi-level namespace;
	}
	{
		using namespace three;
		std::cout << w << std::endl;

	}

	getchar();
	getchar();
	return 0;
}
//the following is in Header1.h

namespace three {
	int w = 30;
	//you can also define functions, classes, etc.
}
