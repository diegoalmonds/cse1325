#include <iostream>
#include <iterator>
#include <set>
#include <map>

#include "Index.h"
#include "Location.h"

void Index::add_word(Word word, std::string filename, int line) { 
    if (_index.find(word) == _index.end()){
        Locations locations;
        _index.insert(std::make_pair(word, locations));
    }
    Location location = Location(filename, line);
    std::map<Word, Locations>::iterator map_iterator = _index.find(word);
    map_iterator->second.insert(Location(filename, line)); 
}

std::ostream& operator<<(std::ostream& ost, Index& index) { 
    std::map<Word, Locations>::iterator index_it = index._index.begin();
    while (index_it != index._index.end()) {
        std::set<Location>::iterator locations_it = index_it->second.begin();
        ost << index_it->first << ": ";
        while (locations_it != index_it->second.end()) { 
            Location current_location = Location(*locations_it);
            ost << current_location;
            locations_it++;
        }
        ost << "\n";
        index_it++;
    }
    return ost;
}