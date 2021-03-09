USE loggingsystemdb;
INSERT INTO Event (Name)
VALUES ('Teaching or Supervision');
INSERT INTO Event (Name)
VALUES ('Design or Plan');
INSERT INTO Event (Name)
VALUES ('Assess or Give Feedback');
INSERT INTO Event (Name)
VALUES ('Discussion');
INSERT INTO Event (Name)
VALUES ('Scholarship');
INSERT INTO Event (Name)
VALUES ('Evaluation and Quality Assurance');


INSERT INTO User (username, name,password, roles,account_created)
VALUES ('rowbo','Tom Rowbotham','$2y$12$WjMvIYEmf0oEJxqkydW5M.QJ6jCv/AGT/p7bvwP82bAC5ZhMikNp2','USER',DATE('2020-11-23'));
INSERT INTO User (username, name,password ,roles,account_created)
VALUES ('clive99','Clive Tsungu','$2y$12$RJ81jxbwYS90sHZ.8sDu2uAoPb0EFWwMy2z6u4lAnJnv21Le/zC8G','ADMIN',DATE('2020-11-23'));
INSERT INTO User (username, name,password ,roles,account_created)
VALUES ('juan10','Jay Creasey','$2y$12$RJ81jxbwYS90sHZ.8sDu2uAoPb0EFWwMy2z6u4lAnJnv21Le/zC8G','USER',DATE('2020-11-23'));


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

INSERT INTO Tags (Category, tag_name, shortened_tag, description)
VALUES ('UKPSF','Design and plan learning activities and/or programmes of study', 'A1','The evidence of Designing and Planning Learning Activities will normally be small scale for Descriptor 1, typically individual activities and/or sessions. This would range from module design to a whole programme of study for Descriptor 2 and those working towards Descriptor 3. In all cases, one would expect the design to reflect developing knowledge and understanding of the Core Knowledge and Professional Values dimensions.');

INSERT INTO Tags (Category, tag_name, shortened_tag, description)
VALUES ('UKPSF','Teach and/or support learning', 'A2','In demonstrating the activities of teaching and supporting learning the evidence should demonstrate an increasing awareness of different approaches to and methods of teaching and supporting learning as well as a growing ability to choose the most appropriate approach for the achievement of curriculum aims.');

INSERT INTO Tags (Category, tag_name, shortened_tag, description)
VALUES ('UKPSF','Assess and give feedback to learners', 'A3','Clear differentiation of how this area is evidenced would be expected for the different Descriptors. For example, for Descriptor 1 an understanding of the importance of assessment and feedback and of the criteria for making informed, formative judgements about work and the role this plays in supporting learning through activities such as tutorials, work placements, observations, and practical work would be appropriate. For Descriptors 2 and 3 there would be an increasing emphasis on the use of feedback and feed-forward approaches being routinely used to improve learning and develop learner autonomy. At Descriptor 4 the focus might be about a wider sphere of influence in policies and practices concerning assessment and feedback in supporting learning.');

INSERT INTO Tags (Category, tag_name, shortened_tag, description)
VALUES ('UKPSF','Develop effective learning environments and approaches to student support and guidance', 'A4','The definition of "learning environments" has been widely contested and is open to diverse interpretation. Individual practitioners work beyond the local physical environment of the classroom, the laboratory, studio or work place or the distance learning or electronic learning environment. They take the nature of the learning environment, the learning culture being developed, the nature and extent of the support infrastructures into account and are able to distinguish between academic and pastoral interventions. Individuals also take the range of environments available to students into account as well as how they are enabled to access, understand and utilise them.');

INSERT INTO Tags (Category, tag_name, shortened_tag, description)
VALUES ('UKPSF','Engage in continuing professional developments in subjects/disciplines and their pedagogy, incorporating research, scholarship and the evaluation of professional practices', 'A5','The Framework provides a powerful means of articulating the varied aspects of role and the potential for development in all areas of the teaching and supporting learning endeavour. This Area of Activity is concerned with enhancement and comprises three elements integral to teaching and supporting learning roles. Whilst the three elements might be viewed holistically it is important the elements are understood and demonstrated, particularly at Descriptors 1 and 2 to ensure successful integration. The three elements are: 1. Continuing professional development in subjects/disciplines and their pedagogy 2. Incorporating research and scholarship 3. The evaluation of (one’s own) professional practices. Evidence could appropriately focus on the question: How might an individual demonstrate that they have become a better teacher through continuing professional development, research and the evaluation of their teaching and learning related practices?');

INSERT INTO Tags (Category, tag_name, shortened_tag, description)
VALUES ('UKPSF','The subject material', 'K1','This area is effectively evidenced with reference to the Areas of Activity or other areas of Core Knowledge. Evidence should fundamentally relate to how an understanding of the nature of the subject is used to inform the design and planning of learning activities and programmes of study, the teaching strategies, the assessment and feedback. This would normally make reference to the distinctive nature, or culture, of the discipline and the particular expectations of teaching; the issues or challenges arising from the context in which teaching takes place, and the appropriate methods of delivering the subject at different levels (e.g. first year undergraduate to masters level).');

INSERT INTO Tags (Category, tag_name, shortened_tag, description)
VALUES ('UKPSF','Appropriate methods for teaching and learning in the subject area and at the level of the academic programme', 'K2','This is concerned with pedagogic approaches that are distinctive and/or characteristic of the subject, or what makes the teaching or supporting of the learning in the subject different to the teaching of another one. It is also concerned with acknowledging that some approaches may be more appropriate than others given the nature of the learning desired, the level of the material being taught and the readiness of students. This is clearly linked to demonstrating Core Knowledge 1 with its focus on an understanding the subject material, but is specifically concerned with the strategies and approaches used to teach or support the learning of the subject.');

INSERT INTO Tags (Category, tag_name, shortened_tag, description)
VALUES ('UKPSF','How students learn, both generally and within their subject/discipline area? ', 'K3','How students learn might be evidenced through demonstrating how an understanding of the characteristics of different learners (such as mature students, recent school leavers or workplace learners) impacts on how their needs might be met in the context of learning, how this might reflect on the learning environment, teaching approaches and practices. Reference could be made to different theories of, or approaches to, learning and how these are evidenced by the use of different strategies for teaching and supporting learning. This might relate specifically to the nature of the subject (Core Knowledge 1).');

INSERT INTO Tags (Category, tag_name, shortened_tag, description)
VALUES ('UKPSF','The use and value of appropriate learning technologies', 'K4','Evidence needs to demonstrate how and why specific technologies, of all types and ages are used appropriately to support learning. Evidence will address what the learning and teaching needs are and why particular technology is used to address them. Evidence is likely to be linked to other areas of Core Knowledge, for example; how and why technology is used within a specific discipline, professional or vocational areas; for specific groups of learners; in specific learning contexts or environments.');

INSERT INTO Tags (Category, tag_name, shortened_tag, description)
VALUES ('UKPSF','Methods for evaluating the effectiveness of teaching', 'K5','An essential part of work in Higher Education is ensuring the effectiveness of teaching practices. This focuses on the methods (formal or informal) employed to gather information and data about the impact of teaching, how they are used and the impact of their use on developing practice.');

INSERT INTO Tags (Category, tag_name, shortened_tag, description)
VALUES ('UKPSF','The implications of quality assurance and quality enhancement for academic and professional practice with a particular focus on teaching', 'K6','Quality assurance and quality enhancement are deeply embedded in higher education through procedures such as programme validation, monitoring and review. These processes shape academic practice and are implicit in what individuals do. Key to evidencing this area is how an individual might demonstrate engagement with feedback to enhance practice and the student learning experience. This might include an account of how they seek opportunities to obtain feedback other than relying on the institutional procedures already in place. For those working outside higher education institutional policies and practices, they will need to evidence a personal interest, understanding and commitment to quality assurance and enhancement procedures established and embedded within their practice. This will include knowledge and understanding of the quality assurance frameworks at a national level and how these are manifested at an institutional level.');

INSERT INTO Tags (Category, tag_name, shortened_tag, description)
VALUES ('UKPSF','Respect individual learners and diverse learning communities', 'V1','This focuses on the way teaching and supporting learning incorporate activities, actions and approaches which respect individual learners. It depicts the ways we communicate and interact with individuals and different communities in the context of teaching and supporting learning. The term "diverse learning communities" might include campus based groups of students, electronic communicates, work based communities, or be defined on the basis of ethnicity, faith, social class, age etc. The practitioner needs to be able to demonstrate that they value and can work effectively with and within these diverse communities.');

INSERT INTO Tags (Category, tag_name, shortened_tag, description)
VALUES ('UKPSF','Promote participation in higher education and equality of opportunity for learners', 'V2','The focus here is on providing evidence of how a commitment to participation in Higher Education and equality of opportunity for learners underpins practice related to teaching and supporting learning. There is potential to cover a broad spectrum of activities, approaches and behaviours linked to all the Areas of Activity and Core Knowledge. Evidence should ideally indicate wide and pervasive approaches to ensuring equality of opportunity.');

INSERT INTO Tags (Category, tag_name, shortened_tag, description)
VALUES ('UKPSF','Use evidence informed approaches and the outcomes from research, scholarship and continuing professional development', 'V3','This focuses on the use of evidence informed approaches, the ability to draw on and contribute to many sources of evidence and to use them to inform teaching and learning practice. It is about using the outcomes from research, scholarship and professional development to make principled, informed and considered judgements which enhance practice and the learning experience. This value advocates the importance of direct professional involvement in enquiry (in teaching and learning) to support the individual’s own professional development and to enhance their teaching or learning support activities.  Evidence might include consideration and application of the findings from studies, reading, personal enquiry of (for example) teaching, learning, learners, the subject, the environment etc to enhance practice and the student learning experience. Using one’s own discipline based research to enhance the curriculum should be informed by reading or research about curriculum design, the nature of the subject itself and the learners in order to provide a rationale for the design of the curriculum and its delivery.');

INSERT INTO Tags (Category, tag_name, shortened_tag, description)
VALUES ('UKPSF','Acknowledges the wider context in which higher education operates recognising the implications for professional practice', 'V4','This is concerned with being alert to the issues that may impact on institutional missions and/or which might have an influence on curriculum design and/or personal and collective professional practice. This might for example include how an individual has responded to the current demands of the Disability Discrimination Act, the employment agenda, or the widening access and participation agenda. Current agendas include; sustainability (the practice of sustainability and education for sustainability), and student engagement.');


-- INSERT INTO Reflection (box1, box2, box3, box4, box5, box6, learning_point1)
-- VALUES ('Held a group activity, went through slides and took questions at the end','I considered my previous seminars and found this format to be effective','Key information was passed along in an interactive and effective manner','I became more comfortable using remote-meeting software', 'I sent a feedback survey to participating students', 'I could have revised some of my slides for brevity',
-- 'Students are more engaged when viewing slides with images, so I should use more images');
--
-- INSERT INTO Reflection (box1, box2, box3, box4, box5, box6, learning_point1)
-- VALUES ('Attended a harvard referencing workshop and cited journals using the referencing style','I thought that I needed to brush up on my skills','I managed to complete a lot of citation activities during the workshop','I used an app to check that my citations were correct', 'I have my completed citations as evidence of the activity', 'I could have spoken up more in the workshop',
-- 'I learnt how to hold a meeting on Zoom.');

INSERT INTO Form (EventID, short_description,RoleID,ReflectionID,username, last_edited, activity_date)
VALUES (1,'Held an hour-long online seminar for Year 2 students on Presentation Skills.',1,null,'rowbo',TIMESTAMP('2020-11-25 15:12:03'), DATE('2020-11-23'));

INSERT INTO Form (EventID, short_description,RoleID,ReflectionID,username, last_edited, activity_date)
VALUES (3,'Held an in person seminar for Year 1 students on Agile Project Management',2,null,'rowbo',TIMESTAMP('2020-11-27 05:22:11'), DATE('2020-11-26'));

INSERT INTO Form (EventID, short_description,RoleID,ReflectionID,username, last_edited, activity_date)
VALUES (2,'Attended a 2 hour long workshop on harvard referencing and how to not accidentally plagiarize work.',3,null,'rowbo',TIMESTAMP('2020-11-29 12:05:56'), DATE('2020-11-30'));

INSERT INTO Tagform (TagID, FormID)
VALUES (2,1);
INSERT INTO Tagform (TagID, FormID)
VALUES (43,1);

INSERT INTO Tagform (TagID, FormID)
VALUES (1,2);

INSERT INTO Tagform (TagID, FormID)
VALUES (6,2);

INSERT INTO Tagform (TagID, FormID)
VALUES (13,2);

INSERT INTO Tagform (TagID, FormID)
VALUES (31,2);

INSERT INTO Tagform (TagID, FormID)
VALUES (3,3);

INSERT INTO Tagform (TagID, FormID)
VALUES (5,3);

INSERT INTO Tagform (TagID, FormID)
VALUES (14,3);

INSERT INTO Tagform (TagID, FormID)
VALUES (31,3);

INSERT INTO Tagform (TagID, FormID)
VALUES (28,3);

-- INSERT INTO action_points (username, learning_point, checked)
-- VALUES ('rowbo', 'Students are more engaged when viewing slides with images, so I should use more images', 0)