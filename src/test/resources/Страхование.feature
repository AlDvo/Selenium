#language: ru

  Функционал: Страхование

    Сценарий: Страхование для путешественников

      Когда выбран пункт основного меню "Страхование"
      И выбран пункт меню "Все страховые программы"
      Когда выбран фильтр страхования "Путешествия"
      И выбрана программа страхования "Страхование для путешественников"

      Когда нажали на кнопку Оформить онлайн
      Когда выбрали сумму страховой защиты "Минимальная"
      Когда нажали кнопку Оформить и переходим к заполнению анкеты

      Тогда заполняются поля:
        |Фамилия / Surname|Петров|
        |Имя / Name|Вася|
        |Дата рождения|11.09.2000|
        |Фамилия страхователя|Сидоров|
        |Имя страхователя|Игнат|
        |Отчество страхователя|Константинович|
        |Дата рождения страхователя|11.09.1980|
        |Серия паспорта|2233|
        |Номер паспорта|454545|
        |Дата выдачи|11.09.2000|
        |Кем выдан|Москва|

      Тогда значения полей равны:
        |Фамилия / Surname|Петров|
        |Имя / Name|Вася|
        |Дата рождения|11.09.2000|
        |Фамилия страхователя|Сидоров|
        |Имя страхователя|Игнат|
        |Отчество страхователя|Константинович|
        |Дата рождения страхователя|11.09.1980|
        |Серия паспорта|2233|
        |Номер паспорта|454545|
        |Дата выдачи|11.09.2000|
        |Кем выдан|Москва|

      Тогда нажали кнопку Оформить , на странице заполнения анкеты
      И присутствует сообщение об ошибке "Поле не заполнено."
      И присутствует сообщение об ошибке "При заполнении данных произошла ошибка"