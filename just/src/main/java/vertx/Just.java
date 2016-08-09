package vertx;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import org.vertx.java.platform.PlatformLocator;
import org.vertx.java.platform.PlatformManager;

public class Just {

	public String getDefaultAddress() {
		Enumeration<NetworkInterface> nets;
		try {
			nets = NetworkInterface.getNetworkInterfaces();
		} catch (final SocketException e) {
			return null;
		}
		NetworkInterface netinf;
		while (nets.hasMoreElements()) {
			netinf = nets.nextElement();

			final Enumeration<InetAddress> addresses = netinf.getInetAddresses();

			while (addresses.hasMoreElements()) {
				final InetAddress address = addresses.nextElement();
				if (!address.isAnyLocalAddress() && !address.isMulticastAddress()
						&& !(address instanceof Inet6Address)) {
					return address.getHostAddress();
				}
			}
		}

		return null;
	}

	public void runVertical() {
		final PlatformManager pm = PlatformLocator.factory.createPlatformManager(0, getDefaultAddress());
		pm.vertx();
	}

	public static void main(String[] args) {
		Just j = new Just();
		System.out.println(j.getDefaultAddress());
		j.runVertical();
	}
}
