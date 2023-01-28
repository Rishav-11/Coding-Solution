 Code Explanation 


Approach - 

I have to find all possibles combination that can be bought under given budget.
           
step 1 - I have stored the given data in List data structure by creating my own NewsPaper class type.
 
step 2 - NewsPaper class type will contain two thing i) Newspaper Name
                                                     ii) Weekly price in the form of array of double.

step 3 - After then i have used two another data structure i) List ii) Map 
         List data structure to store the weekly sum and Map to store weekly sum and newspaper name 
         in the form of key-value pair, to fetch my output accordingly.

step 4 - Weekly Expense, I have calculated by adding all the prices of newspaper on each particular day.


step 5 - After calculating the weekly expense and storing it in List, i have used it to calculate all possible combination
         by passing it in a method.


step 6 - This called, method will give me all the possible combination, but i have to showcase only those combinations in which number 
           of newspaper is maximum. I have used recursive algoritm to solve this problem.

step 7 - In this approach, i will always have two option, either include or exclude, if value of weekly expense <= budget i will include that 
          otherwise i will exclude that element and check for next element. The whole process will take 2^n time complexity.


step 8 - My possible combination will be in the form of weekly expense combination, but I have to change that.

step 9 - That's why I have stored my data is HashMap prevoiusly and using that I have fetched the newspaper name and formed
           all possible combiantions of newspaper subscription. 





