Function details
createCollection(p_collection_name)

indexData(p_collection_name, p_exclude_column):
  Index the given employee data into the specified collection, excluding the column provided in p_exclude_column.

searchByColumn(p_collection_name, p_column_name, p_column_value):
  Search within the specified collection for records where the column p_column_name matches the value p_column_value.

getEmpCount(p_collection_name)

delEmpById(p_collection_name, p_employee_id)

getDepFacet(p_collection_name):
  Retrieve the count of employees grouped by department from the specified collection.
