Paging and sorting of search result page for dealer website
===========================================================
This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.

@author niravpatel
Created by nirav.patel on 19-02-2021

        |data            |CategoryData          |
        |----------------|----------------------|
        |Auto            |Auto onderdelen       |


## Verification of Paging functionality
* Setup and launch browser with Dealer site
* Click on Search Button and Enter text to search "Auto"
* Verify Search Result Completed "valid" for dealer website
* Verify Pagination button visible on screen
* Verify Pagination functionality with switching other options "2"



## Verification of Sorting functionality
* Setup and launch browser with Dealer site
* Click on Search Button and Enter text to search <data>
* Verify Search Result Completed "valid" for dealer website
* Verify Sorting button visible on screen
* Change with other Sorting option and get the data for first section "dealer"
     |SortingOption       |
     |--------------------|
     |Titel volgorde (a-z)|
     |Titel volgorde (z-a)|
     |Prijs (laag-hoog)   |
     |Prijs (hoog-laag)   |
     |Datum (oud-nieuw)   |
     |Datum (nieuw-oud)   |
* Verify all options with data of first section "dealer"
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