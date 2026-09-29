# F.CSA313 Lab 04 — JUnit 5

## Оюутны мэдээлэл

* Нэр: Б.Идэрбат
* Оюутны код: B242270075
* Хичээл: F.CSA313 Software Quality Assurance and Testing
* Лаборатори: Lab 04 — Нэгжийн тестийн эхлэл — JUnit 5

## 1. Орчин

* Java: OpenJDK 21.0.12.1
* Maven: 3.9.9
* JUnit Jupiter: 5.10.2
* Maven Surefire: 3.2.5
* Compiler release: Java 17

## 2. Хэрэгжүүлэлт

`GradeCalculator` класс нь дараах үйлдлүүдийг хийдэг.

* 90+ → A
* 80–89 → B
* 70–79 → C
* 60–69 → D
* 0–59 → F
* 0–100 хүрээнээс гадуур оноо өгвөл `IllegalArgumentException` шиднэ.
* Ирц, лаборатори, сорил болон шалгалтын оноог шалгаж нийт оноог тооцно.

`totalScore()` функцийн дээд хязгаар:

* Ирц: 10
* Лаборатори + бие даалт: 40
* Сорил 1: 10
* Сорил 2: 10
* Шалгалт: 30

Нийт: 100 оноо.

## 3. Unit Tests

Нийт 14 test method байна.

* 12 энгийн `@Test` method
* 2 `@ParameterizedTest` method

`letterGrade()` болон `totalScore()` функцуудыг parameterized test ашиглан олон өгөгдлөөр шалгасан.

Дараах boundary value-уудыг шалгасан:

* 90
* 89.99
* 60
* 59.99
* 0
* 100

Мөн дараах буруу утгуудыг шалгасан:

* `score = -1`
* `score = 101`
* `att = -5`
* `lab = 41`

Эдгээр тохиолдолд `IllegalArgumentException` шидэгдэж байгаа эсэхийг шалгасан.

## 4. Test Result

Тест ажиллуулах команд:

```bash
mvn test 2>&1 | tee results/mvn-test.txt
```

Эцсийн үр дүн:

```text
Tests run: 25, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

Parameterized test-ийн CSV өгөгдлийн мөр бүр Maven дээр тусдаа test case гэж тоологдсон. Тиймээс нийт 14 test method боловч Maven-ийн тайланд 25 test case ажилласан гэж гарсан.

## 5. Mutation Testing

Mutation testing хийхдээ `GradeCalculator.java` файлын:

```java
if (score >= 90)
```

нөхцөлийг түр хугацаанд:

```java
if (score > 90)
```

болгож өөрчилсөн.

Дараа нь дараах командыг ажиллуулсан:

```bash
mvn test 2>&1 | tee results/mvn-test-mutant.txt
```

Mutation test-ийн үр дүн:

```text
Tests run: 25, Failures: 2, Errors: 0, Skipped: 0
BUILD FAILURE
```

`90` оноо A байх ёстой гэсэн хоёр test унасан. Үүнд `ninetyIsExactlyA` болон parameterized test-ийн `90, A` case багтсан.

Энэ нь тестүүд `>= 90` нөхцөлийг `> 90` болгосон mutation-ийг илрүүлж чадсаныг харуулж байна.

Mutation testing-ийн дараа кодыг буцааж:

```java
if (score >= 90)
```

болгосон.

Дахин тест ажиллуулахад бүх 25 test амжилттай болсон.

## 6. Reflection

Энэ лабораториор JUnit 5 ашиглан Java кодыг unit test-ээр шалгаж сурсан. AAA буюу Arrange, Act, Assert бүтэц нь тестүүдийг ойлгомжтой зохион байгуулахад тусалсан. Boundary value testing ашиглан 90, 89.99, 60, 59.99 зэрэг хязгаарын утгуудыг тусгайлан шалгасан. Parameterized test ашигласнаар ижил логикийг олон input дээр давтаж шалгах боломжтой болсон. Мөн `IllegalArgumentException` ашиглан буруу input-уудыг шалгаж сурсан. Mutation testing нь зөвхөн тест амжилттай ажиллаж байгаа эсэхээс гадна тестүүд кодын өөрчлөлт болон алдааг илрүүлж чадаж байгаа эсэхийг шалгадаг гэдгийг ойлгосон. Ялангуяа `>= 90`-ийг `> 90` болгоход 90 онооны тестүүд унасан нь boundary test-ийн ач холбогдлыг харуулсан.

## 7. Results Files

* `results/mvn-test.txt` — эцсийн амжилттай test result
* `results/mvn-test-mutant.txt` — mutation test-ийн failure result

## 8. Screenshots

* `screenshots/01-mvn-test-success.png`
* `screenshots/02-mvn-test-mutant.png`
* `screenshots/lab04-junit-test-success.png`
* `screenshots/pom.xml`
