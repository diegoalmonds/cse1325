#include <iostream>

class Time
{
    public:
        Time(int hour = 0, int minute = 0, int second=0);
        Time operator+(Time time);
        Time& operator++();
        Time operator++(int);
        bool operator==(Time& time);
        bool operator!=(Time& time);
        bool operator<(Time& time);
        bool operator>(Time& time);
        bool operator<=(Time& time);
        bool operator>=(Time& time);
        friend std::ostream& operator<<(std::ostream& ost, Time& time);
        friend std::istream& operator>>(std::istream& ist, Time& time);    
    private:
        int _hour;
        int _minute;
        int _second;
        void rationalize();
};