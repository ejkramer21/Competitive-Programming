#include<iostream>
#include<vector>
#include<string>

//#includre<bits/stdc++>

using namespace std;

int main() {

    // fast io
   ios_base::sync_with_stdio(false);
   cin.tie(NULL);

   string word;
   int second, curr;
   int numWords;
   int first=-1;

   cin >> numWords;



   string * words = new string[numWords];
   int * pointers = (int*)malloc(sizeof(int) * numWords);
   int * headers = (int*)malloc(sizeof(int)*numWords);

 //  cout<<numWords;
 // cout.flush();
   for (int i = 0; i<numWords;i++) {
       cin>>words[i];
       pointers[i]=-1;
       headers[i]=i;
   }

   //cout<<"after first";
   //cout.flush();
   for(int i=0;i<numWords-1;i++){ //inf loop

       int test = numWords-i;

     //  cout<<test;
       //cout.flush();

       cin>>first;
       first--;
       cin>>second;
       second--;

       pointers[headers[first]]=second;
       headers[first]=headers[second];
       headers[second]=-1;
   }

   curr=first;

   if(numWords == 1) {
       curr = 0;
   }

   //cout<<"before last";
   //cout.flush();
   while (pointers[curr]!=-1){
       word = words[curr];
       cout<<word;
       curr=pointers[curr];
   }
   cout<<words[curr];
   cout<<"\n";

}