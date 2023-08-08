/**
 * Return a Rectangle constructor function
 * Rectangle instances should contain x and y properites
 * and they should know how to calculate their area and perimeter
 */
exports.createRectangleConstructor = function() {

    function Rectangle(x, y) {
        this.x = x;
        this.y = y;
    }

    Rectangle.prototype.calculateArea = function() {
        return this.x * this.y;
    };

    Rectangle.prototype.calculatePerimeter = function() {
        return 2 * (this.x + this.y);
    };

    return Rectangle;
};

/**
 * Return a constructor function that
 * subclasses the provided constructor
 */
exports.createSubClass = function(fn) {
};


