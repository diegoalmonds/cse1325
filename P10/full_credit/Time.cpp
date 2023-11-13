#include "Time.h"
#include <iostream>

Time::Time(int hour, int minute, int second) : _hour{hour}, _minute{minute}, _second{minute} {rationalize();};

void Time::rationalize()
{
    int extra_minutes = 0;
    int extra_hours = 0;
    if (_second < 0 || _second > 59)
    {
        extra_minutes = _second / 60;
        _second = _second % 60;
    }
    _minute += extra_minutes;
    if (_minute < 0 || _minute > 59)
    {
        extra_hours = _minute / 60;
        _minute = _minute % 60;
    }
    _hour += extra_hours;
    if (_hour < 0 || _hour > 23)
        _hour = 0;
}

Time Time::operator+(Time time)
{
    this->_hour += time._hour;
    this->_minute += time._minute;
    this->_second += time._second;
    rationalize();
}

std::ostream& operator<<(std::ostream& ost, Time& time)
{
    ost << time._hour << ":" << time._minute << ":" << time._second;
    return ost;
}

std::istream& operator>>(std::istream& ist, Time& time)
{
    //this is wrong, just a placeholder so i don't get an error
    ist >> time._hour;
    ist >> time._minute;
    ist >> time._second;

    return ist;
}