# CoDecide

## The smarter way to find common ground

**CoDecide** is a Java based local decision-making tool that allows users to submit their prefrences anonymouslys.Once all the users have submitted their prefrences **CoDecide** computes an aggregated result that reflects collective prioritization — not just a majority vote. Helping the group reach an agreement without the usual chaos in groupchats. **Designed to reduce bias, deadlocks, confusion and decision fatigue.**

### Why is **CoDecide** Unique ?

- **Anonymity-First** Design - *no bias due to peer visiblity.*
- **Supports complex decision dynamics** - *beyond the usual yes/no.*
- **Uses ranked aggregration** - *no more basic linear voting.*

The app is perfect for groups like roomates, friends, or project teammates who wish to have a low conflict and minimal confrontation to reach a consensus.

**CoDecide** comes from a problem we all run into very frequentlyt: trying to make decisions in a group, and getting nowhere. Whether it's choosing a place to eat, setting a meeting time, or planning an event, the group chat always turns into a mess — people stay silent, others dominate, and nothing actually gets decided. When I came across the paper **"Making Better Decisions in Groups by Bang and Frith"***(1)*, it clicked. The authors talk about how group decisions can actually be better than individual ones — but only if you remove social pressure and give people space to think on their own. That idea stuck with me.
This project is my way of putting that insight into action. CoDecide lets people quietly submit their preferences, then finds a fair group result without anyone having to argue or feel awkward. I wanted to build something simple, useful, and grounded in actual research.

*(1)* *Bang, D. & Frith, C.D. (2021)*. **Making Better Decisions in Groups**. *Philosophical Transactions of the Royal Society B, 376(1824).*[link to article](https://royalsocietypublishing.org/doi/10.1098/rsos.170193)

### User Stories

1. As a User I want make a Poll and add Options to it
2. As a User I want to add my group members to it.
3. As a User I want to be able to vote for these Options on the 0-100 scale.
4. As a User I want to get the result of my Poll.
5. As a User I want to save my details once after signup for login and not have to signup multiple times
6. As a User I want to save my Poll for documentation and record purposes.

### End User Instructions
On your welcome screen you can choose to Login or Signup. You can also see my visual component the App logo in this screen.

If you choose Signup you will have to fill in all your details and login again with your credentials.

After login you can
create a new poll - you can add the option by filling in the field and then clicking the "Add Option" button. You can also see the added options in the scroll pane below.

Once done adding options to your poll you can click the "Next" button - After which you can add your desired other users to the Poll by simply entering their usernames.You can also see the added usernames in the scroll pane below.

Once done adding users to your poll you can click the "Next" button - After which the current person logged in will vote for the options. Once voted using the slider on the scale of 0-100 you can click the "Submit" button.

After the "Submit" button next user in the list will login and do the same until the last user clicks the "Submit" button.

The current user logged in will get other buttons.
- "View Results" which will prompt the Owner of the Poll to Login Only.
- "Return to Home" which will keep the current logged in user and bring them to the home screen
- "Logout" which will log out the current user logged in but keep the app running for other user to use.
- "Quit" which will log out the user save the required details and close the app.

After Login you can
View past results - you can view the results for polls which have been completed and you are the owner for. in the screen you will also get other buttons.

- "Return to Home" which will keep the current logged in user and bring them to the home screen
- "Logout" which will log out the current user logged in but keep the app running for other user to use.
- "Quit" which will log out the user save the required details and close the app.


User does not need to manually save or load anything in the App. All of those are already taken care of.


### Phase 4 Task 2
Mon Aug 04 13:10:49 PDT 2025
User: b.k Login Successful! 
Mon Aug 04 13:10:49 PDT 2025
New session login by b.k
Mon Aug 04 13:10:52 PDT 2025
New option: A added to PollId: 1
Mon Aug 04 13:10:55 PDT 2025
New option: B added to PollId: 1
Mon Aug 04 13:11:01 PDT 2025
User : John added to Poll: 1
Mon Aug 04 13:11:05 PDT 2025
User b.k voted 85 for option: A
Mon Aug 04 13:11:05 PDT 2025
User b.k voted 80 for option: B
Mon Aug 04 13:11:12 PDT 2025
User: doe.john Login Unsuccessful! 
Mon Aug 04 13:11:24 PDT 2025
User: doe.john Login Successful! 
Mon Aug 04 13:11:24 PDT 2025
New session login by doe.john
Mon Aug 04 13:11:29 PDT 2025
User doe.john voted 85 for option: A
Mon Aug 04 13:11:29 PDT 2025
User doe.john voted 75 for option: B
