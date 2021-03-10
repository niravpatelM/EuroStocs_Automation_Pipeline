Search functionality – free text search, category search, combination, auto complete
====================================================================================
This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.

@author niravpatel
Created by nirav.patel on 13-01-2021


## Verification of Search functionality – Free text Search scenarios with valid data
* Setup and launch browser
* Click on Search Button and Enter text to search "Campers en Caravans"
* Verify Search Result Completed "valid"


## Verification of Search functionality – Free text Search scenarios with invalid data
* Setup and launch browser
* Click on Search Button and Enter text to search "abcdrecord"
* Verify Search Result Completed "invalid"


## Verification of Search functionality –  Category Search scenarios with all options
* Setup and launch browser
* Change category search and Verify search
         |CategorySearch                        |
         |--------------------------------------|
         |Accessoires                           |
         |Antiek en Kunst                       |
         |Auto onderdelen                       |
         |Banden en Velgen                      |
         |Camper & Caravan onderdelen           |
         |Diensten en Vakmensen                 |
         |Doe-het-zelf en Verbouw               |
         |Fietsen, Brommers en Scooters         |
         |Huis en Inrichting                    |
         |Landbouw onderdelen                   |
         |Merchandise en Collectie              |
         |Motorfiets onderdelen                 |
         |Overig                                |
         |Styling en Tuning                     |
         |Trailer en aanhangwagen onderdelen    |
         |Tuin en terras                        |
         |Voertuigen                            |
         |Vrachtwagen onderdelen                |
         |Watersport                            |
         |Werkplaats en Materialen              |



## Verification of Search functionality – Combination Search scenarios with valid data
* Setup and launch browser
* Click on Search Button and Enter text to search "achterbumper prijs op aanvraag"
* Select option from dropdown list "Auto onderdelen"
* Verify Search Result Completed "valid"


## Verification of Search functionality – Combination Search scenarios with invalid data
* Setup and launch browser
* Click on Search Button and Enter text to search "achterbumper prijs op aanvraag"
* Select option from dropdown list "Watersport"
* Verify Search Result Completed "invalid"



## Verification of Search functionality – Auto Complete Search scenarios
* Setup and launch browser
* Click on Search Button and Enter text to search "Auto"
* Verify auto search dropdown with option


_______________
* Quit browser