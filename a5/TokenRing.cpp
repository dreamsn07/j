
#include<bits/stdc++.h>

using namespace std;

int main()
{
    int token = 0;
    int n;
    cout<<"Enter the number of Nodes: "<<endl;
    cin>>n;

    cout<<"Ring formed is: ";
    for(int i=0; i<n; i++)
    {
       cout<<i<<" ";
    }
    cout<<0<<endl;

    int sender, receiver, data;

    while(true)
    {
        cout<<"Enter Sender: "<<endl;
        cin>>sender;

        cout<<"Enter Receiver: "<<endl;
        cin>>receiver;

        cout<<"Enter the Data:"<<endl;
        cin>>data;

        //passing token until sender is found
        for(int i=token; (i%n)!=sender;i=(i+1)%n)
        {
            cout<<i<<"->";
        }
        cout<<sender<<endl;

        //sending data in mutual exclusion
        for(int i=(sender)%n; i!=receiver;i=(i+1)%n)
        {
            cout<<"Sender "<<(i%n)<<" sent data "<<data<<" to "<<(i+1)%n<<endl;
        }

        //releasing token
        token = sender;
        cout<<"Token is at: "<<token<<endl;
    }

  return 0;  
}
