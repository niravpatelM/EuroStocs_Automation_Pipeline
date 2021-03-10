Paging and sorting of search result page
========================================
This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.

@author niravpatel
Created by nirav.patel on 18-01-2021

        |data            |CategoryData          |
        |----------------|----------------------|
        |Auto onderdelen |Auto onderdelen       |
        |Autos           |Vrachtwagen onderdelen|


## Verification of Paging functionality
* Setup and launch browser
* Click on Search Button and Enter text to search <data>
* Verify Search Result Completed "valid"
* Verify Pagination button visible on screen
* Verify Pagination functionality with switching other options "3"



## Verification of Sorting functionality
* Setup and launch browser
* Click on Search Button and Enter text to search <data>
* Verify Search Result Completed "valid"
* Verify Sorting button visible on screen
* Change with other Sorting option and get the data for first section "eurostocks"
     |SortingOption       |
     |--------------------|
     |Titel volgorde (a-z)|
     |Titel volgorde (z-a)|
     |Prijs (laag-hoog)   |
     |Prijs (hoog-laag)   |
     |Datum (oud-nieuw)   |
     |Datum (nieuw-oud)   |
* Verify all options with data of first section "eurostocks"
     |SortingOption       |
     |--------------------|
     |Titel volgorde (a-z)|
     |Titel volgorde (z-a)|
     |Prijs (laag-hoog)   |
     |Prijs (hoog-laag)   |
     |Datum (oud-nieuw)   |
     |Datum (nieuw-oud)   |




## Verification of Sorting functionality using category search
* Setup and launch browser
* Select option from dropdown list <CategoryData>
* Verify Search Result Completed "valid"
* Verify Sorting button visible on screen
* Change with other Sorting option and get the data for first section "eurostocks"
     |SortingOption       |
     |--------------------|
     |Titel volgorde (a-z)|
     |Titel volgorde (z-a)|
     |Prijs (laag-hoog)   |
     |Prijs (hoog-laag)   |
     |Datum (oud-nieuw)   |
     |Datum (nieuw-oud)   |
* Verify all options with data of first section "eurostocks"
     |SortingOption       |
     |--------------------|
     |Titel volgorde (a-z)|
     |Titel volgorde (z-a)|
     |Prijs (laag-hoog)   |
     |Prijs (hoog-laag)   |
     |Datum (oud-nieuw)   |
     |Datum (nieuw-oud)   |


_______________
* Quit browser