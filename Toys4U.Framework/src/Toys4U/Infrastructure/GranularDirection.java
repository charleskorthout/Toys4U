package Toys4U.Infrastructure;

public class GranularDirection {

        int degree;
        
        public GranularDirection() {
            this.degree = 0;
        }
        
        /**
         * Constructor using a degree (360)
         * @param degree 
         */
        public GranularDirection(int degree) {
            this.degree = degree;
        }
        
        /**
         * Constructor using a compass direction
         * @param direction 
         */
        public GranularDirection(Direction direction) {
            this.degree = fromDirection(direction);
        }
        
	/**
	 * Turns from the current direction
	 * @param degree
	 */
	public void turn(int degree) {
		this.degree = (this.degree + degree ) % 360;
	}

        
        public void turn(Direction direction) {
                this.turn(fromDirection(direction));
        }
	/**
	 * 
	 * @param degree
	 */
	public void setDirection(int degree) {
		// TODO - implement GranularDirection.setDirection
		throw new UnsupportedOperationException();
	}
        
        /**
         * Convert a Compass direction to a degree -360 - 360
         * @param direction The compass direction
         * @return the integer holding the degree of the angle of the direction
         */
        private int fromDirection(Direction direction) {
            switch (direction) 
            {
                case NORTH:
                    return 0;
                case NORTHEAST:
                    return 45;
                case EAST :
                    return 90;
                case SOUTHEAST:
                    return 135;
                case SOUTH:
                    return 180;
                case SOUTHWEST:
                    return 225;
                case WEST:
                    return 270;
                default: 
                    return 315;
            }
        }

}