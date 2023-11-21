#ifndef __LOCATION_H
#define __LOCATION_H

#include <iostream>

class Location {
    public:
        Location(std::string filename, int line);
        bool operator==(const Location& location) const;
        bool operator!=(const Location& location) const;
        bool operator<(const Location& location) const;
        bool operator>(const Location& location) const;
        bool operator<=(const Location& location) const;
        bool operator>=(const Location& location) const;
        friend std::ostream& operator<<(std::ostream& ost, Location& location) ;
    private:
        std::string _filename;
        int _line;
};

#endif