from flask import Flask, render_template, request

app = Flask(__name__)

@app.route('/')
def home():
    return render_template('index.html')

@app.route('/calculate', methods=['POST'])
def calculate():
    num1 = float(request.form['num1'])
    num2 = float(request.form['num2'])
    operation = request.form['operation']

    if operation == 'addition':
        result = num1 + num2
        operation_text = 'sum'
    elif operation == 'subtraction':
        result = num1 - num2
        operation_text = 'difference'
    elif operation == 'multiplication':
        result = num1 * num2
        operation_text = 'product'
    elif operation == 'division':
        if num2 != 0:
            result = num1 / num2
            operation_text = 'quotient'
        else:
            return 'Error: Division by zero'
    else:
        return 'Error: Invalid operation'

    return f'The {operation_text} of {num1} and {num2} is {result}'

if __name__ == '__main__':
    app.run(debug=True)
