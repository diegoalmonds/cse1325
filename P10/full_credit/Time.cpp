#include "Time.h"
#include <iostream>
#include <iomanip>

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
    time._hour += this->_hour;
    time._minute += this->_minute;
    time._second += this->_second;
    rationalize();
    return time;
}

Time& Time::operator++()
{
    this->_second++;
    rationalize();
    return *this;
}

Time Time::operator++(int)
{
    this->_second++;
    rationalize();
    return *this;
}

bool Time::operator==(Time& time)
{
    if (this->_hour == time._hour)
    {
        if (this->_minute == time._minute)
        {
            if (this->_second == time._second)
                return true;
        }
    }
    return false;
}

bool Time::operator!=(Time& time)
{
    if (this->_hour == time._hour)
    {
        if (this->_minute == time._minute)
        {
            if (this->_second == time._second)
                return false;
        }
    }
    return true;
}

bool Time::operator<(Time& time)
{
    if (this->_hour < time._hour)
        return true;
    if (this->_minute < time._minute)
        return true;
    if (this->_second < time._second)
        return true;
    return false;
}

bool Time::operator>(Time& time)
{
    if (this->_hour > time._hour)
        return true;
    if (this->_minute > time._minute)
        return true;
    if (this->_second > time._second)
        return true;
    return false;
}

bool Time::operator<=(Time& time)
{
    if (this->_hour < time._hour)
        return true;
    else if (this->_hour == time._hour)
    {
        if (this->_minute < time._minute)
            return true;
        else if (this->_minute == time._minute)
        {
            if (this->_second < time._second)
                return true;
            else if (this->_second == time._second)
                return true;
        }
    }
    return false;
}

bool Time::operator>=(Time& time)
{
    if (this->_hour > time._hour)
        return true;
    else if (this->_hour == time._hour)
    {
        if (this->_minute > time._minute)
            return true;
        else if (this->_minute == time._minute)
        {
            if (this->_second > time._second)
                return true;
            else if (this->_second == time._second)
                return true;
        }
    }
    return false;
}

std::ostream& operator<<(std::ostream& ost, const Time& time)
{
    ost << std::setfill('0') << std::setw(2) << time._hour;
    ost << ":" << std::setfill('0') << std::setw(2) << time._minute;
    ost << ":" << std::setfill('0') << std::setw(2) << time._second;
    return ost;
}

std::istream& operator>>(std::istream& ist, Time& time)
{
    ist >> time._hour;
    ist.ignore(1, ':');
    ist >> time._minute;
    ist.ignore(1, ':');
    ist >> time._second;
    return ist;
}