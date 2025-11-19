# app.py
from pathlib import Path
from flask import Flask, render_template, request, flash
import os

app = Flask(__name__)
app.config['SECRET_KEY'] = '-5wrxc$4&MN-Po7Lf@8@1a-D*!G7EyPVe-dzKP0KPP!U-eOvl2IWid%-'


@app.route('/')
def home():
    return render_template('index.html', title='Главная', heading='Миссия Колонизация Марса', show_links=True)


@app.route('/index')
def index():
    return render_template('index.html', title='Девиз', heading='И на Марсе будут яблони цвести!')


@app.route('/promotion')
def promotion():
    advertisement = [
        "Человечество вырастает из детства.",
        "Человечеству мала одна планета.",
        "Мы сделаем обитаемыми безжизненные пока планеты.",
        "И начнем с Марса!",
        "Присоединяйся!"
    ]
    return render_template('promotion.html', title='Реклама', advertisement=advertisement)


@app.route('/image_mars')
def image_mars():
    return render_template('image_mars.html', title='Привет, Марс!')


@app.route('/astronaut_selection', methods=['GET', 'POST'])
def astronaut_selection():
    if request.method == 'POST':
        flash('Ваша анкета записана.')

    professions = [
        "инженер-исследователь", "пилот", "строитель",
        "экзобиолог", "врач", "инженер по терраформированию",
        "климатолог", "специалист по радиационной защите",
        "астрогеолог", "гляциолог", "инженер жизнеобеспечения",
        "метеоролог", "оператор марсохода", "киберинженер",
        "штурман", "пилот дронов"
    ]
    return render_template('astronaut_selection.html', title='Отбор астронавтов', professions=professions)


@app.route('/results/<nickname>/<int:level>/<float:rating>')
def results(nickname, level, rating):
    return render_template('results.html', title='Результаты отбора', nickname=nickname, level=level, rating=rating)


@app.route('/photo/<nickname>', methods=['GET', 'POST'])
def photo(nickname):
    filepath = None
    if request.method == 'POST':
        file = request.files.get('photo')
        if file and file.filename.split('.')[1] == 'jpg':
            filename = nickname + '.jpg'
            file.save(os.path.join('static/images', filename))
        else:
            flash('Пожалуйста, выберите изображение в формате jpg.')

    if Path(f"static/images/{nickname}.jpg").exists():
        filepath = f"images/{nickname}.jpg"

    return render_template('photo.html', title='Фото участника', nickname=nickname, filepath=filepath)


@app.route('/carousel')
def carousel():
    images = [
        "mars1.jpg",
        "mars2.jpg",
        "mars3.jpg"
    ]
    return render_template('carousel.html', title='Галерея Марса', images=images)


if __name__ == '__main__':
    app.run(port=8080, debug=True)
