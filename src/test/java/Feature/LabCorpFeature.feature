Feature: Verify LabCorp Job Posting Information

Scenario: Verify job posting details for QA Test Automation Developer
    Given I am on the LabCorp website
    When I navigate to the Careers page
    And I search for "Quality Analyst"
    And I select a job listing
    Then I confirm job title
    And I confirm job location
    And I confirm job ID
    And I confirm job details