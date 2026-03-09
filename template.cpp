#include <iostream>
#include <fstream>
#include <cstring>
#include <ctime>
using namespace std;

template <typename T>
bool validateYear(T year)
{
    time_t t = time(0);
    tm* now = localtime(&t);
    int currentYear = now->tm_year + 1900;

    return (year >= 2000 && year <= currentYear);
}

class Vehicle
{
protected:
    char regNo[30];
    char model[30];
    char manufacturer[30];
    int year;

public:
    static int vehicleCount;

    Vehicle()
    {
        vehicleCount++;
    }

    void inputBase()
    {
        cout << "Enter Registration Number: ";
        cin.getline(regNo,30);

        if(strlen(regNo)==0)
            throw "Registration number cannot be empty";

        cout << "Enter Model Name: ";
        cin.getline(model,30);

        cout << "Enter Manufacturer: ";
        cin.getline(manufacturer,30);

        cout << "Enter Year: ";
        cin >> year;

        if(!validateYear(year))
            throw "Invalid year";

        cin.ignore();   
    }


    inline string formatDisplay()
    {
        string s="RegNo: ";
        s+=regNo;
        s+=", Model: ";
        s+=model;
        s+=", Manufacturer: ";
        s+=manufacturer;
        s+=", Year: ";
        s+=to_string(year);
        return s;
    }

    virtual void input()=0;
    virtual void displayInfo()=0;
    virtual void writeToFile(ofstream&)=0;

    virtual ~Vehicle(){}
};

int Vehicle::vehicleCount=0;

class Car: public Vehicle
{
    char fuelType[20];

public:

    void input()
    {
        inputBase();

        cout<<"Enter Fuel Type: ";
        cin.getline(fuelType,20);
    }

    void displayInfo()
    {
        cout<<formatDisplay()
            <<", FuelType: "<<fuelType<<endl;
    }

    void writeToFile(ofstream &fout)
    {
        char type='C';

        fout.write(&type,sizeof(type));
        fout.write((char*)this,sizeof(Car));
    }
};

class Bike: public Vehicle
{
    char engineCapacity[20];

public:

    void input()
    {
        inputBase();

        cout<<"Enter Engine Capacity: ";
        cin.getline(engineCapacity,20);
    }

    void displayInfo()
    {
        cout<<formatDisplay()
            <<", EngineCapacity: "<<engineCapacity<<endl;
    }

    void writeToFile(ofstream &fout)
    {
        char type='B';

        fout.write(&type,sizeof(type));
        fout.write((char*)this,sizeof(Bike));
    }
};

int main()
{
    int n;

    cout<<"Enter number of vehicles: ";
    cin>>n;
    cin.ignore(); 

    Vehicle* vehicles[100];

    ofstream fout("vehicle.dat",ios::binary);

    for(int i=0;i<n;i++)
    {
        char type;

        cout<<"Enter type of vehicle (C for Car, B for Bike): ";
        cin>>type;
        cin.ignore();

        try
        {
            if(type=='C'||type=='c')
                vehicles[i]=new Car();

            else if(type=='B'||type=='b')
                vehicles[i]=new Bike();

            else
                throw "Invalid vehicle type";

            vehicles[i]->input();
            vehicles[i]->writeToFile(fout);
        }

        catch(const char* msg)
        {
            cout<<"Error: "<<msg<<endl;
            i--;
        }
    }

    fout.close();


    ifstream fin("vehicle.dat",ios::binary);

    cout<<"\nVehicle Records\n";

    while(true)
    {
        char type;

        fin.read(&type,sizeof(type));

        if(fin.eof())
            break;

        Vehicle* v;

        if(type=='C')
        {
            v=new Car();
            fin.read((char*)v,sizeof(Car));
        }

        else
        {
            v=new Bike();
            fin.read((char*)v,sizeof(Bike));
        }

        v->displayInfo();

        delete v;
    }

    fin.close();

    cout<<"\n---------------------------------\n";
    cout<<"Total Vehicles stored: "<<Vehicle::vehicleCount<<endl;

    return 0;
}
