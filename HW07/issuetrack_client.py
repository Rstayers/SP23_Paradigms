import requests
import csv

# Base URL of the API
BASE_URL = 'http://jcssdev.pythonanywhere.com/'

def get_data(endpoint):
    """
    Helper function to perform a GET request to the specified endpoint.
    """
    bugs = []
    response = requests.get(BASE_URL + endpoint)
    response_json= response.json()
    while response_json['count'] != len(bugs):

        if response.status_code == 200:
            for bug in response_json['results']:
                bugs.append(bug)
        if response_json['next'] != None:
            response = requests.get(response_json['next'])
            response_json= response.json()
    return bugs

def write_csv(filename, data, header):
    """
    Helper function to write data to a CSV file.
    """
    with open(filename, mode='w', newline='', encoding='utf-8') as file:
        writer = csv.writer(file, delimiter=',', quotechar='"', quoting=csv.QUOTE_MINIMAL)
        writer.writerow(header)
        for row in data:
            writer.writerow(row)

def total_bugs_per_package():
    """
    Retrieves all bugs and calculates the total number of bugs per package.
    """
    bugs = get_data('bugs')
    
    if bugs is not None:
        package_count = {}
        for bug in bugs:
            package = bug.get('package')
            package_count[package] = package_count.get(package, 0) + 1

        # Prepare data for CSV
        data = [(package, count) for package, count in package_count.items()]
        # Write to CSV
        write_csv('total_bugs_per_package.csv', data, ['Package', 'Total Bugs'])

def total_comments_per_bug():
    """
    Retrieves all comments and calculates the total number of comments per bug.
    """
    comments = get_data('comments')
    if comments is not None:
        bug_count = {}
        for comment in comments:
            
            bug_id = comment.get('bug')
            bug_id = bug_id.rstrip('/').split('/')[-1]
            bug_count[bug_id] = bug_count.get(bug_id, 0) + 1

        # Prepare data for CSV
        data = [(bug_id, count) for bug_id, count in bug_count.items()]
        # Write to CSV
        write_csv('total_comments_per_bug.csv', data, ['Bug ID', 'Total Comments'])

if __name__ == '__main__':
    total_bugs_per_package()
    total_comments_per_bug()

