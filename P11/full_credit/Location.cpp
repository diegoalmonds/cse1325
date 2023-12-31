#include <iostream>

#include "Location.h"

Location::Location(std::string filename, int line) 
    : _filename{filename}, _line{line} { };

bool Location::operator==(const Location& location) const {
    if (this->_filename == location._filename)
        if (this->_line == location._line)
            return true;
    return false;
}

bool Location::operator!=(const Location& location) const {
    return !(operator==(location));
}

bool Location::operator<(const Location& location) const { //fixed both issues in the email, getting a seg fault now after running
    if (this->_filename < location._filename)
        return true;
    else if (this->_filename == location._filename)
        if (this->_line < location._line)
            return true;
    return false;
}

bool Location::operator>(const Location& location) const { 
    if (this->_filename > location._filename)
        return true;
    else if (this->_filename == location._filename)
        if (this->_line > location._line)
            return true;
    return false;
}

bool Location::operator<=(const Location& location) const { 
    if (this->_filename <= location._filename)
        return true;
    if (this->_line <= location._line)
        return true;
    return false;
}

bool Location::operator>=(const Location& location) const { 
    if (this->_filename >= location._filename)
        return true;
    if (this->_line >= location._line)
        return true;
    return false;
}

std::ostream& operator<<(std::ostream& ost, Location& location) {
    ost << location._filename << " line " << location._line;
    return ost;
}
