class Solution {
    public double average(int[] salary) {
        int minSalary = Integer.MAX_VALUE;
        int maxSalary = Integer.MIN_VALUE;
        int totalSalary = 0;
        int numEmployees = 0;
        
        for (int s : salary) {
            if (s < minSalary) {
                minSalary = s;
            }
            if (s > maxSalary) {
                maxSalary = s;
            }
            totalSalary += s;
            numEmployees++;
        }
        
        totalSalary -= minSalary + maxSalary;
        numEmployees -= 2;
        
        return (double) totalSalary / numEmployees;
    }
}