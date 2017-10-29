
import java.lang.reflect.Field;
import java.lang.reflect.Array;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * This class is used to parse command-line arguments based on a the
 * variables with an object.  Each variable in the class specifies a
 * command-line argument that can be accepted; the name of the variable
 * becomes the name of the command-line argument.  As Java does not allow
 * dashes '-' in variables, use two underscores '__' if you want a dash in
 * an argument.  Also, if you want to have a numeric argument (e.g.: '-1'),
 * start the variable name with a single underscore.  JCLO uses reflection
 * to determine the type of each variable in the passed object and sets the
 * values in the object passed to it via parsing the command line.  If you
 * include a String array named "additional", all non-dashed arguments will
 * be placed in it.
 *
 * @author Steve Beaty (beatys@mscd.edu) @version    $Id:
 *         JCLO.java,v 1.5 2007/11/01 16:43:12 beaty Exp beaty $
 */

public class JCLO {
    private final Field[] fields;
    private final Object object;
    private boolean doubleDashes;
    private boolean hasEquals;
    private String prefix = "";
    private final String[][] aliases;

    /**
     * A constructor that takes the Object that contains the variables
     * acceptable on a command line.  Call parse (String) to do the actual
     * parsing.
     *
     * @param object where the variables/arguments are
     */
    public JCLO(Object object) {
        this(null, object, null);
    }

    /**
     * A constructor that takes the Object that contains the variables
     * acceptable on a command line.  Call parse (String) to do the actual
     * parsing.
     *
     * @param object  where the variables/arguments are
     * @param aliases if there are CLO aliases
     */
    public JCLO(Object object, String[][] aliases) {
        this(null, object, aliases);
    }

    /**
     * A constructor that takes the Object that contains the variables
     * acceptable on a command line.  Call parse (String) to do the actual
     * parsing.
     *
     * @param object where the variables/arguments are
     * @param prefix if all CLO variables start with a prefix
     */
    public JCLO(String prefix, Object object) {
        this(prefix, object, null);
    }

    /**
     * A constructor that takes an Object, a prefix, and a boolean that
     * specifies whether to accept single or double dashes; call parse
     * (String) to do the actual parsing.
     *
     * @param object  where the variables/arguments are
     * @param prefix  the String CLO's start with, if any
     * @param aliases if there are CLO aliases
     */
    public JCLO(String prefix, Object object, String[][] aliases) {
        this.object = object;
        this.prefix = prefix;
        this.aliases = aliases;

        fields = object.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
        }
    }

    /**
     * Just a simple method to put the try/catch in one place.
     *
     * @param f the Field to get the value of
     * @return the Object with the value
     */
    private Object getObject(Field f) {
        try {
            return (f.get(object));
        } catch (java.lang.IllegalAccessException iae) {
            iae.printStackTrace();
            System.exit(1);
        }

        return (null);
    }

    private Field getField(String key) {
        if (prefix != null)
            key = prefix + key;

        for (Field field : fields) {
            String name = field.getName();

            if (name.equals(key))
                return (field);
        }

        return (null);
    }

    /**
     * Get the current value of the variable in the object
     *
     * @param key the variable name
     * @return an Object with the value

    private Object getValue(String key) {
        Field f = getField(key);

        if (f == null) {
            System.out.println("Field not found: " + key);
            return (null);
        }

        return (getObject(f));
    }
    */

    /**
     * Just a simple method to put the try/catch in one place.
     *
     * @param f the Field to set the value of
     * @param o the Object with the value
     */
    private void setObject(Field f, Object o) {
        try {
            f.set(object, o);
        } catch (java.lang.IllegalAccessException iae) {
            iae.printStackTrace();
        }
    }

    private String getArrayType(Class type) {
        return (type.getComponentType().toString().replaceFirst
                ("class.*\\.", ""));
    }

    /**
     * An external representation of the object
     *
     * @return a formatted version of this object
     */
    @Override
    public String toString() {
        String r = "";
        boolean first = true;

        for (Field field : fields) {
            String key = field.getName();
            Class type = field.getType();
            Object object = getObject(field);

            if (!first) r += "\n";
            first = false;

            if (type.isArray()) {
                r += getArrayType(type) + "[]" + ": " + key + " = ";
                r += java.util.Arrays.toString((Object[]) object);
            } else {
                r += type.toString().replaceFirst("class java.lang.", "") +
                        ": " + key + " = " + object;
            }
        }

        return (r);
    }

    private String getUsageType(Class type) {
        String dd = (doubleDashes ? "=" : " ");

        if (type.getName().equals("boolean") || type.getName().equals("java.lang.Boolean")) {
            return (doubleDashes ? "[=boolean]" : "");
        } else if (type.isArray()) {
            return dd + getArrayType(type) + "...";
        } else if (type.isEnum()) {
            return dd + Arrays.toString(type.getEnumConstants());
        } else {
            return dd +
                type.getName().replaceFirst("java.lang.", "");
        }
    }

    /**
     * Create and usage message for the acceptable command line variables.
     *
     * @return a String that specifies acceptable options
     */
    public String usage() {
        List<String> list = new ArrayList<String>();

        for (Field field : fields) {
            String key = field.getName();
            Class type = field.getType();

            if (key.equals("additional"))
                continue;

            if (prefix != null) {
                if (!key.startsWith(prefix))
                    continue;
                else
                    key = key.replaceFirst("^" + prefix, "");
            }

            if (Modifier.isFinal(field.getModifiers()))
                continue;

            key = key.replaceFirst("^_([0-9])", "$1");
            key = key.replaceAll("__", "-");
            key = key.replaceAll("_\\$", ".");

            list.add((doubleDashes ? "--" : "-") + key +
                    getUsageType(type) + "\n");
        }

        Collections.sort(list);

        String r = "";
        for (String l : list)
            r += l;

        return (r);
    }

    private void parseAdditional(String args[], int i) {
        int number = args.length - i;
        String add[] = new String[number];

        for (int j = 0; j < number; j++, i++) {
            add[j] = args[i];
        }

        Field f = getField("additional");
        if (f != null) {
            setObject(f, add);
        } else {
            System.err.println("No varible 'additional' found");
        }
    }

    /**
     * Add to object o to the end of the array contained in field and
     * return the resulting array.
     *
     * @param field the field in the object
     * @param o     the new object to be placed at the end
     * @return a formatted version of this object
     */
    private Object addToArray(Field field, Object o) {
        Object ret;
        Object orig = getObject(field);
        Class componentType = field.getType().getComponentType();

        if (orig == null) {   // the array is empty
            ret = Array.newInstance(componentType, 1);
            Array.set(ret, 0, o);
        } else {
            int length = Array.getLength(orig);

            ret = Array.newInstance(componentType, length + 1);

            int j;
            for (j = 0; j < length; j++)
                Array.set(ret, j, Array.get(orig, j));

            Array.set(ret, j, o);
        }

        return (ret);
    }

    private String getKey(String arg) {
        if (hasEquals)
            arg = arg.replaceFirst("=.*", "");

        if (doubleDashes)
            arg = arg.substring(2);
        else
            arg = arg.substring(1);

        // variables can't start with a number and can't have a dash
        arg = arg.replaceAll("^([0-9])", "_$1");
        arg = arg.replaceAll("-", "__");
        arg = arg.replaceAll("\\.", "_\\$");

        if (aliases != null)
            for (String[] aliase : aliases)
                if (aliase[0].equals(arg))
                    arg = aliase[1];

        return (arg);
    }

    private String getBooleanValue(String arg) {
        if (hasEquals) {
            // remove the argument name
            arg = arg.replaceFirst("[^=]*=", "");

            if (arg.equalsIgnoreCase("true") || arg.equalsIgnoreCase("yes"))
                return ("true");
            else
                return ("false");
        } else {
            return ("true");
        }
    }

    /**
     * Make an Object of the correct type for the field, using a String
     * version of the value to create it.
     *
     * @param type a String representing the base (or String) type
     * @param val  the value
     * @return an Object of the correct type and value
     */
    private Object makeObject(String type, String val) {
        // System.out.println("type = " + type);
        // System.out.println("val = " + val);
        if(type=="boolean"||type=="java.lang.Boolean")
        {
        	return Boolean.valueOf(val);
        }else if(type=="byte")
        {
        	return Byte.valueOf(val);
        }else if(type=="short")
        {
        	return Short.valueOf(val);
        }else if(type=="int")
        {
        	return Integer.valueOf(val);
        }else if(type=="float")
        {
        	return Float.valueOf(val);
        }else if(type=="double")
        {
        	return Double.valueOf(val);
        }else if(type=="long")
        {
        	return Long.valueOf(val);
        }else if(type=="string")
        {
        	return val;
        }else if(type=="char")
        {
        	return val.charAt(0);
        }
        throw new IllegalArgumentException("Unknown type: " + type);
    }

    private String getEqualsValue(String arg) {
        if (!arg.contains("=")) {
            throw (new IllegalArgumentException
                    ("'" + arg + "' requires '=VALUE'"));
        } else {
            return (arg.replaceFirst("[^=]*=", ""));
        }
    }

    /**
     * Parse a command line.
     *
     * @param args the arguments to be parsed
     */
    public void parse(String args[]) {
        for (int i = 0; i < args.length; i++) {
            if (!args[i].startsWith("-")) {
                parseAdditional(args, i);
                return;
            }

            doubleDashes = args[i].startsWith("--");
            hasEquals = args[i].contains("=");

            String key = getKey(args[i]);
            // System.out.println("key = " + key);
            Field field = getField(key);
            // System.out.println("field = " + field);

            if (field == null) {
                throw (new IllegalArgumentException ("No such option: \"" + key + "\""));
            }

            Class type = field.getType();
            // System.out.println("type = " + type);
            String name = type.getName();
            // System.out.println ("name = " + name);

            if (type.isArray())
                name = type.getComponentType().getName();

            String value;

            if (name.equals("boolean") || name.equals("java.lang.Boolean"))
                value = getBooleanValue(args[i]);
            else if (doubleDashes || hasEquals)
                value = getEqualsValue(args[i]);
            else
                value = args[++i];

            // horrible hack as i can't figure out how to call a generic class's toValue,
            // so we'll pretend the are primitive types and call makeObject.
            if (! type.isPrimitive()) {
                name = name.replaceFirst("java.lang.", "").toLowerCase();
            }

            Object o = type.isEnum() ? Enum.valueOf(type, value) : makeObject(name, value);

            if (type.isArray())
                o = addToArray(field, o);

            setObject(field, o);
        }
    }
}
