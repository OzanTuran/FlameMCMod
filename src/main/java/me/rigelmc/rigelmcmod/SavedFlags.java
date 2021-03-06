package me.rigelmc.rigelmcmod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import me.rigelmc.rigelmcmod.util.FLog;
import static me.rigelmc.rigelmcmod.util.FUtil.SAVED_FLAGS_FILENAME;

public class SavedFlags extends FreedomService
{

    public SavedFlags(RigelMCMod plugin)
    {
        super(plugin);
    }

    @Override
    protected void onStart()
    {
    }

    @Override
    protected void onStop()
    {
    }

    @SuppressWarnings("unchecked")
    public Map<String, Boolean> getSavedFlags()
    {
        Map<String, Boolean> flags = null;

        File input = new File(RigelMCMod.plugin().getDataFolder(), SAVED_FLAGS_FILENAME);
        if (input.exists())
        {
            try
            {
                try (FileInputStream fis = new FileInputStream(input); ObjectInputStream ois = new ObjectInputStream(fis))
                {
                    flags = (HashMap<String, Boolean>) ois.readObject();
                }
            }
            catch (IOException | ClassNotFoundException ex)
            {
                FLog.severe(ex);
            }
        }

        return flags;
    }

    public boolean getSavedFlag(String flag) throws Exception
    {
        Boolean flagValue = null;

        Map<String, Boolean> flags = getSavedFlags();

        if (flags != null)
        {
            if (flags.containsKey(flag))
            {
                flagValue = flags.get(flag);
            }
        }

        if (flagValue != null)
        {
            return flagValue;
        }
        else
        {
            throw new Exception();
        }
    }

    public void setSavedFlag(String flag, boolean value)
    {
        Map<String, Boolean> flags = getSavedFlags();

        if (flags == null)
        {
            flags = new HashMap<>();
        }

        flags.put(flag, value);

        try
        {
            final FileOutputStream fos = new FileOutputStream(new File(plugin.getDataFolder(), SAVED_FLAGS_FILENAME));
            final ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(flags);
            oos.close();
            fos.close();
        }
        catch (Exception ex)
        {
            FLog.severe(ex);
        }
    }

}
