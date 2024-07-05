CREATE TABLE TB_MOVIE (
	MOVIE_CODE	VARCHAR2(10)	NOT NULL,
	MOVIE_TITLE	VARCHAR2(60)	NOT NULL,
	GENRE	VARCHAR2(20)	NULL,
	SUMMARY	VARCHAR2(500)	NULL,
	DIRECTOR	VARCHAR2(30)	NULL,
	ACTOR	VARCHAR2(80)	NULL,
	RUNNING_TIME	VARCHAR2(20)	NULL,
	RATING	VARCHAR2(5)	NOT NULL,
	POSTER_URL	VARCHAR2(80)	NULL,
	OPENED_DATE	VARCHAR2(30)	NULL
);


CREATE TABLE TB_MOVIE_SCHEDULE (
	SCREENING_ID	NUMBER	NOT NULL,
	SCREEN_CODE	VARCHAR2(10)	NOT NULL,
	STARTTIME VARCHAR(10)	NOT NULL,
	ENDTIME	VARCHAR(10)	NOT NULL,
	STARTDATE VARCHAR(15)	NOT NULL,
	ENDDATE	VARCHAR(15)	NOT NULL,
	MOVIE_CODE	VARCHAR2(10)	NOT NULL
);

CREATE TABLE TB_THEATER (
	THEATER_CODE	VARCHAR(10)	NOT NULL,
	THEATER_NAME	VARCHAR(20)	NULL,
	THEATER_ADDR	VARCHAR(100)	NULL,
	LOCATION_X	NUMBER	NULL,
	LOCATION_Y	NUMBER	NULL
);

CREATE TABLE TB_SCREEN (
	SCREEN_CODE	VARCHAR(10)	NOT NULL,
	THEATER_CODE	VARCHAR(10)	NOT NULL,
	SCREEN_NO	NUMBER	NULL,
	SEAT	NUMBER	NULL
);