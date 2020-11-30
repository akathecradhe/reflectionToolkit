

INSERT INTO Event (Name, event_date)
VALUES ('Teaching or Supervision',TO_DATE('2020-11-23', 'YYYY-MM-DD'));
INSERT INTO Event (Name, event_date)
VALUES ('Design or Plan',TO_DATE('2020-11-23', 'YYYY-MM-DD'));
INSERT INTO Event (Name, event_date)
VALUES ('Assess or Give Feedback',TO_DATE('2020-11-23', 'YYYY-MM-DD'));
INSERT INTO Event (Name, event_date)
VALUES ('Discussion',TO_DATE('2020-11-23', 'YYYY-MM-DD'));
INSERT INTO Event (Name, event_date)
VALUES ('Scholarship',TO_DATE('2020-11-23', 'YYYY-MM-DD'));
INSERT INTO Event (Name, event_date)
VALUES ('Evaluation and Quality Assurance',TO_DATE('2020-11-23', 'YYYY-MM-DD'));

INSERT INTO User (username, name,password ,account_created)
VALUES ('rowbo','Tom Rowbotham',"hello123" ,TO_DATE('2020-11-23', 'YYYY-MM-DD'));
INSERT INTO User (username, name, password  , account_created)
VALUES ('clive99','Clive Tsungu',"youtube4" ,TO_DATE('2020-11-23', 'YYYY-MM-DD'));

INSERT INTO Role (name)
VALUES ('Lead or Facilitate');
INSERT INTO Role (name)
VALUES ('Participate');
INSERT INTO Role (name)
VALUES ('Review');

INSERT INTO Tags (Category, tag_name)
VALUES ('Others Involved','No-one');

INSERT INTO Tags (Category, tag_name)
VALUES ('Others Involved','Students');

INSERT INTO Tags (Category, tag_name)
VALUES ('Others Involved','Staff');

INSERT INTO Tags (Category, tag_name)
VALUES ('Impact','Self');

INSERT INTO Tags (Category, tag_name)
VALUES ('Impact','School, Institute or Department');

INSERT INTO Tags (Category, tag_name)
VALUES ('Impact','Institution');

INSERT INTO Tags (Category, tag_name)
VALUES ('Impact','National');

INSERT INTO Tags (Category, tag_name)
VALUES ('Impact','International');

INSERT INTO Tags (Category, tag_name)
VALUES ('Learning Technologies','None');

INSERT INTO Tags (Category, tag_name)
VALUES ('Learning Technologies','Online learning environment or resource');

INSERT INTO Tags (Category, tag_name)
VALUES ('Learning Technologies','Blog, Wiki or social media');

INSERT INTO Tags (Category, tag_name)
VALUES ('Learning Technologies','Polling or response system');

INSERT INTO Tags (Category, tag_name)
VALUES ('Learning Technologies','Reflective log or portfolio');

INSERT INTO Tags (Category, tag_name)
VALUES ('Learning Technologies','Mobile and app technology');

INSERT INTO Tags (Category, tag_name)
VALUES ('Learning Technologies','Analogue technology');

INSERT INTO Tags (Category, tag_name)
VALUES ('Thought Cloud','Worked well');

INSERT INTO Tags (Category, tag_name)
VALUES ('Thought Cloud','Motivational');

INSERT INTO Tags (Category, tag_name)
VALUES ('Thought Cloud','Context');

INSERT INTO Tags (Category, tag_name)
VALUES ('Thought Cloud','Something new');

INSERT INTO Tags (Category, tag_name)
VALUES ('Thought Cloud','Out of my comfort zone');

INSERT INTO Tags (Category, tag_name)
VALUES ('Thought Cloud','Had a go');

INSERT INTO Tags (Category, tag_name)
VALUES ('Thought Cloud','Good response');

INSERT INTO Tags (Category, tag_name)
VALUES ('Thought Cloud','Needs more work');

INSERT INTO Tags (Category, tag_name)
VALUES ('Thought Cloud','Back to the drawing board');

INSERT INTO Tags (Category, tag_name)
VALUES ('Thought Cloud','Phone a friend');

INSERT INTO Tags (Category, tag_name)
VALUES ('Thought Cloud','Apprehensive');

INSERT INTO Tags (Category, tag_name)
VALUES ('Thought Cloud','Cautious');

INSERT INTO Tags (Category, tag_name)
VALUES ('Thought Cloud','Confident');

INSERT INTO Tags (Category, tag_name)
VALUES ('Thought Cloud','Excited');

INSERT INTO Tags (Category, tag_name)
VALUES ('Thought Cloud','Depressed');

INSERT INTO Tags (Category, tag_name)
VALUES ('Thought Cloud','Frustrated');

INSERT INTO Reflection (box1, box2, box3, box4, box5, box6, learning_point1, learning_point2, learning_point3)
VALUES ('Held a group activity, went through slides and took questions at the end','I considered my previous seminars and found this format to be effective','Key information was passed along in an interactive and effective manner','I became more comfortable using remote-meeting software', 'I sent a feedback survey to participating students', 'I could have revised some of my slides for brevity',
'I learnt how to hold a meeting on Zoom.','I learnt how to use a custom background with my webcam','I learnt that students seemed to be more visually attentive when viewing slides with images');

INSERT INTO Form (EventID, short_description,RoleID,ReflectionID,username, last_edited)
VALUES (1,'Held an hour-long online seminar for Year 2 students on Presentation Skills',1,1,'rowbo',CURRENT_TIMESTAMP);

INSERT INTO TagForm (TagID, FormID)
VALUES (2,1);

INSERT INTO TagForm (TagID, FormID)
VALUES (7,1);

INSERT INTO TagForm (TagID, FormID)
VALUES (12,1);

INSERT INTO TagForm (TagID, FormID)
VALUES (30,1);
