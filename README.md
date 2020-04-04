# koatuu-parser
Парсер КОАТУУ | Державний класифікатор об'єктів адміністративно-територіального устрою України

State Classifier of objects of administrative and territorial structure of Ukraine.

Converter from KOATUU to insert sql scripts for specified database schema

## Usage
```bash
java -jar koatuu-parser-1.0.jar ~/koatuu http://www.ukrstat.gov.ua/klasf/st_kls/koatuu.zip KOATUU_02032020.xls
```
where is:
* `~/koatuu` - destination path where files will be unzipped and sql script will be created;
* `http://www.ukrstat.gov.ua/klasf/st_kls/koatuu.zip` - url to download koautuu zip with .xls files;
* `KOATUU_02032020.xls` - name of the file which will be parsed.

## Built With
* zip4j
* poi
* jooq
* postgresql

## Algorithm
1. Download and extract zip.
2. Parse specified file from extracted zip to objects ([LocationDTO](/src/main/java/io/github/tkaczenko/koatuuparser/model/local/LocationDTO.java)).
3. Generate insert sql script for specified table ([Location](/src/main/java/io/github/tkaczenko/koatuuparser/entity/tables/Location.java))

If you want to change the algorithm of parsing, check this [KoatuuParser](/src/main/java/io/github/tkaczenko/koatuuparser/service/local/KoatuuParser.java))

If you want to generate custom insert sql script for your specific database schema, just look at [LocationWriter](/src/main/java/io/github/tkaczenko/koatuuparser/service/local/LocationWriter.java).

Also you need to change database settings at [pom.xml](pom.xml), [application.yml](/src/main/resources/application.yml)

Also you can check used models [model](/src/main/java/io/github/tkaczenko/koatuuparser/model)

## Information about data source
* [http://www.ukrstat.gov.ua/klasf/st_kls/op_koatuu_2016.htm](http://www.ukrstat.gov.ua/klasf/st_kls/op_koatuu_2016.htm)
* XLS: [http://www.ukrstat.gov.ua/klasf/st_kls/koatuu.zip](http://www.ukrstat.gov.ua/klasf/st_kls/koatuu.zip)

## Code structure

Code consists from 10 chars:

| Char number | Description |
| ---  | ------------- |
| 1,2  | Level 1 code  |
| 3    | Level 2 type  |## Code structure

Code consists from 10 chars:

| Char number | Description |
| ---  | ------------- |
| 1,2  | Level 1 code  |
| 3    | Level 2 type  |
| 4,5  | Level 2 code  |
| 6    | Level 3 type  |
| 7,8  | Level 3 code  |
| 9,10 | Level 4 code  |

### Level 2 type (char 3)

| Char number | Description |
|---|---|
| 1 | міста обласного значення |
| 2 | райони Автономної Республіки Крим, області |
| 3 | райони міст, що мають спеціальний статус |

### Level 3 type (char 6)

| Char number | Description |
|---|---|
| 1 | міста районного значення |
| 2 | is unused |
| 3 | райони в містах обласного значення |
| 4 | селища міського типу, що входять до складу міськради |
| 5 | селища міського типу, що входять до складу райради |
| 6 | селища міського типу, що входять до складу райради в місті |
| 7 | міста, що входять до складу міськради |
| 8 | сільради, що входять до складу райради |
| 9 | сільради, села, що входять до складу райради міста, міськради |
