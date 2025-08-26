Feature: Redbus application

Background:

    Given the "Chrome" browser is launched 
    
    
    Scenario:
       When user click on From Field
       And  User Eneter value as "Mumbai"
       And user select value from dropdown
       And User enter destination location value as "Pune"
       And user select value To dropdown
       And User select month and year as "September 2025" and date as "20"
       Then user click on SearchBus button
       Then user search PrimoBus
       And user search ACBus
       And Scroll to the bottom of the page to load all bus operator
       And Store Operator Names
       And  Print Total Buses and Operator names