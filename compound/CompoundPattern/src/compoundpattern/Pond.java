/* 
 * Copyright (C) 2018 Tom McCallum
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package compoundpattern;

/**
 *
 * @author Tom McCallum
 */
public class Pond {
    public void listen() {
        // VERSION 1: non factory version
//        Quackable m = new QuackCounter(new MallardDuck());
//        Quackable r = new QuackCounter(new RedheadDuck());
//        Quackable d = new QuackCounter(new DuckCall());
//        Quackable b = new QuackCounter(new RubberDuck());
    
        // VERSION 2: using a factory we detach Pond from the decorated
        // classes
        CountingDuckFactory factory = new CountingDuckFactory();
        Quackable m = factory.createMallardDuck();
        Quackable r = factory.createRedheadDuck();
        Quackable d = factory.createDuckCall();
        Quackable b = factory.createRubberDuck();
        
        
        // we don't want to count adapted Geese
        Quackable goose = new GooseAdapter(new Goose());
        
        System.out.println("Listening...");
        
        // VERSION 3: add Composite pattern - Flock
        System.out.println("Listen to flock");
        Flock flock = new Flock();
        flock.add( m );
        flock.add( r );
        flock.add( b );
        flock.add( d );
        flock.add( goose );
        flock.register(new Quackologist());
        listen(flock);
        
        System.out.println("Listen to individuals");
        
        listen(m);
        listen(r);
        listen(d);
        listen(b);
        listen(goose);
        
        System.out.println("Quacks: "+QuackCounter.getQuackCount());
    }
    
    /**
     * Using overload here to handle just one duck
     * Using polymorphism here so that all our animals can use the
     * same function
     * @param q 
     */
    public void listen(Quackable q) {
        q.quack();
    }
}
