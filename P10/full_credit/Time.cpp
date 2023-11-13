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
    std::string hours, minutes, seconds;
    std::getline(std::cin, hours, ':');
    std::getline(std::cin, minutes, ':');
    std::getline(std::cin, seconds, ':');
    time._hour = stoi(hours);
    time._minute = stoi(minutes);
    time._second = stoi(seconds);
    return ist;
}