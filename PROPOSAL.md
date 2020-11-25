# teamdlibrary formal proposal

Authors
Brian Pribis, Patrick McCombs, Oluwaseyi Adegoke, Austin Heil, Joshua Moye.

Roles
Brian Pribis - Team leader, programmer
Oluwaseyi Adegoke - program
Austin Heil - *Yet to be assigned*
Joshua Moye  - *Yet to be assigned*
Patrick McCombs - Programmer, Tester

Description and Goals

Team D will work on and deliver a (very) simple library automation system. We believe this project will best represent the parameters of the team project in that it will demonstrate an implementation of three ADT’s in order to effectively and efficiently handle the use cases of the system. 

Use cases
The following use cases will be implemented:
Catalogue cards which, like the old time cards once found in libraries, will represent books along with:
User who checked the book out,
Date when the book was checked out,
Deletion of a card/book
Addition of a card/book
Search for a book title
Search for a user
Bulk import. In order to perform any substantial analysis, we will need a sufficiently large set of records. This use case itself will not be analysed; it will simply be a helper class in order to accomplish the expected goals]. 

Data structures and algorithms
The following ADT and/or algorithms will be used to demonstrate various aspects of the program, especially determining the most efficient methodology for successfully implementing the above use cases [Note, we will be focusing on the cards primarily and will be using them for a majority of the analyses. When appropriate, library patrons may be mentioned and analysed in reference to the analysis of the cards. But they will not be the primary focus for this project].

Red-black binary tree
HashMap   
Linked list (Ordered by card)

Eachcard will include:
Title
Description
Card catalogue number
Link (pointer) to a patron who has checked the book out. 

Each patron will contain:
First name
Last name
Analysis

The final paper will include analysis of time complexities, rational and other observations and feedback from all who were involved in the project. 
Summary

The above program, once finished, will be tested and analyzed for efficiency (Big-O), with code and report provided.

Appendix A - Style Guide

To make things a bit more consistent, the following short list of rules should be followed:

K&R style of brackets:

function(){
   ...
}

Camel case for classes, functions and variables.  Begin class with uppercase and function names and variables with lower case:

class TheClass{

	functionBar(){
	}
}

Constant variables use all uppercase. Use underscores to separate words:

THIS_IS_A_CONSTANT
Multiline comments will use /*...*/ while single live or inline comments use the double slash: //…



