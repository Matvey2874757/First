<!-- File: README.md -->
# Zoom Mod (Fabric 1.21.1)

Готовый минимальный мод на Fabric для Minecraft **1.21.1**.

## Что делает
- Удерживаешь **C** → приближение (уменьшается FOV).
- Отпускаешь **C** → возвращается прошлый FOV.

## Требования
- JDK **21**
- Gradle (или gradle wrapper)

## Как собрать `.jar`

### Вариант 1: если есть Gradle
```bash
gradle build
```

### Вариант 2: создать wrapper и собрать
```bash
gradle wrapper
./gradlew build
```

После сборки файл будет в:

```text
build/libs/zoommod-1.0.0.jar
```

## Установка
1. Установи Fabric Loader для Minecraft 1.21.1.
2. Положи собранный `.jar` в папку `mods`.
3. Запусти игру.

## Изменить клавишу
В игре: `Options -> Controls -> Key Binds -> Zoom Mod -> Zoom`.
