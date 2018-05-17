package com.example.demo.algorithm;

import java.util.BitSet;

public class AlgorithmGeoHash {
    private static final int numbers = 20;
    final static char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'j', 'k', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
            'x', 'y', 'z' };

    /**
     *
     * @param lat 纬度
     * @param lon 经度
     * @return
     */
    public String encode(double lat, double lon){
        return base32(encodeLong(lat, lon));
    }

    public BitSet getBits(double value, double floor, double ceiling) {
        BitSet bitSet = new BitSet(numbers);

        for (int i=0; i<numbers; i++){
            double mid = (floor + ceiling) / 2;
            if (value >= mid){
                bitSet.set(i);
                floor = mid;
            } else {
                ceiling = mid;
            }
        }

        return bitSet;
    }

    public long encodeLong(double lat, double lon){
        BitSet latBits = getBits(lat, -90, 90);
        BitSet lonBits = getBits(lon, -180, 180);

        StringBuffer buffer = new StringBuffer();
        for (int i=0; i<numbers; i++){
            buffer.append(lonBits.get(i) ? '1' : '0');
            buffer.append(latBits.get(i) ? '1' : '0');
        }

        return Long.parseLong(buffer.toString(), 2);
    }



    public String base32(long value){
        char[] buf = new char[65];
        int charPos = 64;
        boolean negative = (value < 0);
        if (!negative)
            value = -value;
        while (value <= -32) {
            buf[charPos--] = digits[(int) (-(value % 32))];
            value /= 32;
        }
        buf[charPos] = digits[(int) (-value)];

        if (negative)
            buf[--charPos] = '-';
        return new String(buf, charPos, (65 - charPos));
    }

    public static void main(String[] args) {
        AlgorithmGeoHash geoHash = new AlgorithmGeoHash();
        System.out.println(geoHash.encode(40.222012, 116.248283));
    }
}
