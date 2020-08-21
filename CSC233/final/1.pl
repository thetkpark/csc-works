% stat(0, 0, 0, 0).
% stat(1, 1408636, 22802, 83425).
% stat(2, 269520, 1377, 26920).
% stat(3, 232243, 10899, 2116).
% stat(4, 226463, 3403, 32692).
% stat(5, 221216, 1402, 30911).

% covid(X, Y, Z, N) :- N > 0, 
% Next is N-1, covid(NextX, NextY, NextZ, Next), 
% stat(N, ThisX, ThisY, ThisZ), 
% X is ThisX + NextX,
% Y is ThisY + NextY,
% Z is ThisZ + NextZ.
% covid(0, 0, 0, 0).
% covid(X, Y, Z, N) :- N > 0, 
% TempN is N-1, covid(X1,Y1,Z1,TempN), 
% stat(A,B,C,N), 
% X is A+X1, Y is B+Y1, Z is C+Z1.

% Define the facts
covidStat(0,0,0,0).
covidStat(1408636,22802,83425,1).
covidStat(269520,1377,26920,2).
covidStat(232243,10899,2116,3).
covidStat(226463,3403,32692,4).
covidStat(221216,1402,30911,5).

% Define the rules of coivd
covid(0,0,0,0).
covid(X,Y,Z,N) :- N > 0, Next is N-1, 
covid(NextX, NextY, NextZ, Next), 
covidStat(ThisX, ThisY, ThisZ, N), 
X is ThisX + NextX, Y is ThisY + NextY, Z is ThisZ + NextZ.