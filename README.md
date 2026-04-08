# Thunder Hammer Mod (Fabric 1.21.1)

Простой мод для Minecraft Fabric **1.21.1**, который добавляет новое оружие — **Thunder Hammer**.

## Что добавлено
- Новый предмет-оружие: `thunder_hammer`.
- Крафт в верстаке.
- Работает как усиленный меч (на базе материала Netherite).

## Рецепт крафта

```text
N N N
N S N
  S
```

- `N` = Netherite Ingot
- `S` = Stick

## Как собрать `.jar`

### 1) Установить JDK 21
Проверь:

```bash
java -version
```

Должен быть Java 21.

### 2) Собрать мод
Если есть Gradle:

```bash
gradle build
```

Или через wrapper:

```bash
gradle wrapper
./gradlew build
```

### 3) Где лежит готовый файл
После сборки `.jar` будет здесь:

```text
build/libs/zoommod-1.0.0.jar
```

## Установка
1. Установи Fabric Loader для Minecraft **1.21.1**.
2. Скопируй `.jar` в папку `mods`.
3. Запусти игру.
